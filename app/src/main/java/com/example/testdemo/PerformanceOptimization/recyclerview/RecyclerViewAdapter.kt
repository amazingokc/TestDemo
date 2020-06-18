import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import kotlinx.android.synthetic.main.activity_recycler_view.view.*

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var dataList: ArrayList<String> = ArrayList();

    init {
        dataList.apply {
            add("11")
            add("22")
            add("33")
            add("44")
            add("55")
            add("66")
            add("77")
            add("88")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerviewadapter_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tv.apply {
            text = dataList[position]
            setOnClickListener {
                dataList.add(position , "addData")
                notifyItemInserted(position )
                notifyItemRangeChanged(position, dataList.size - position)
            }
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv: TextView = itemView.findViewById(R.id.tv_adapter_item)

    }
}