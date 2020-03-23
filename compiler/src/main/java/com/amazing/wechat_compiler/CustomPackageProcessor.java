package com.amazing.wechat_compiler;

import com.amazing.wechat_annotation.CustomPackage;
import com.google.auto.service.AutoService;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

//set SupportedAnnotationTypes,need pack path
@SupportedAnnotationTypes("com.amazing.wechat_annotation.CustomPackage")
public class CustomPackageProcessor extends AbstractProcessor {
    private Elements elementUtils;

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Set<? extends Element> elememts = roundEnvironment.getElementsAnnotatedWith(CustomPackage.class);
        if (elememts != null) {
            for (Element element : elememts) {

                CustomPackage customPackage = element.getAnnotation(CustomPackage.class);
                String packageName = customPackage.packageName();

                //some check
                if (packageName.isEmpty()) {
                    throw new IllegalArgumentException("packageName can't be null or empty");
                }
                TypeElement typeElement;
                if (element instanceof TypeElement) {
                    typeElement = (TypeElement) element;
                } else {
                    typeElement = (TypeElement) element.getEnclosingElement();
                }
                Set<Modifier> modifiers = typeElement.getModifiers();
                if (modifiers.contains(Modifier.FINAL)) {
                    throw new IllegalArgumentException(typeElement.getQualifiedName() + " must be not final class");
                }
                if (!modifiers.contains(Modifier.PUBLIC)) {
                    throw new IllegalArgumentException(typeElement.getQualifiedName() + " must be public class");
                }
                if (typeElement.getKind() == ElementKind.INTERFACE) {
                    throw new IllegalArgumentException(typeElement.getQualifiedName() + " must be class not interface");
                }
                if (typeElement.getSimpleName().equals(typeElement.getQualifiedName())) {
                    throw new IllegalArgumentException(typeElement.getQualifiedName() + " must be have package");
                }
                for (Element field : elementUtils.getAllMembers(typeElement)) {
                    if (field.getModifiers().contains(Modifier.ABSTRACT) && field.getKind() == ElementKind.METHOD) {
                        throw new IllegalArgumentException(typeElement.getQualifiedName() + " must don't have abstract method , but find " + field.toString());
                    }
                }

                //create class which named WXEntryActivity
                TypeSpec WXEntryActivity = TypeSpec.classBuilder(typeElement.getSimpleName().toString())
                        .addModifiers(Modifier.PUBLIC)
                        .superclass(ParameterizedTypeName.get(typeElement.asType())) //set superclass
                        .build();

                //create file
                JavaFile javaFile = JavaFile.builder(packageName, WXEntryActivity)
                        .build();

                try {
                    //write to file
                    javaFile.writeTo(processingEnv.getFiler());
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
            return true;
        } else {
            return false;
        }

    }

    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.elementUtils = processingEnv.getElementUtils();
        this.processingEnv = processingEnv;
    }

}
