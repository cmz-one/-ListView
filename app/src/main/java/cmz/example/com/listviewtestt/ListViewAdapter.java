package cmz.example.com.listviewtestt;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by cmz_o on 2016/5/28.
 */
public class ListViewAdapter extends ArrayAdapter {

    private int selectItem = -1;

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
    }

    public ListViewAdapter(Context context, int resource, List<ItemData> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        ItemData itemData = (ItemData) getItem(position);
        if(convertView ==null)
        {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(getContext()).inflate(R.layout.listview_item, null);
            viewHolder.textView = (TextView) view.findViewById(R.id.itemText);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        if (position == selectItem) {	//选中状态
            view.setBackgroundColor(Color.parseColor("#DEDEDE"));
        } else {	//正常状态
            view.setBackgroundColor(Color.WHITE);
        }
        viewHolder.textView.setText(itemData.getName());
        return view;
    }
    class ViewHolder{
        TextView textView;
    }

}
