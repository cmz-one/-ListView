package cmz.example.com.listviewtestt;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ItemData> array = new ArrayList<ItemData>();
    ListView listView;
    ListViewAdapter adapter;
    ListView listView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initItemData();
        listView = (ListView) findViewById(R.id.listleft);
        adapter = new ListViewAdapter(this,R.layout.listview_item,array);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //view.setBackgroundColor(Color.parseColor("#F5F5DC"));
                adapter.setSelectItem(position);
                adapter.notifyDataSetChanged();
                final String[] citys=initCitys(position);
                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,citys);
                listView2 = (ListView) findViewById(R.id.listright);
                listView2.setBackgroundColor(Color.parseColor("#DEDEDE"));
                listView2.setAdapter(adapter2);
                listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(MainActivity.this,citys[position],Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private String[] initCitys(int position){
       String[]citys = {};
        switch (position){
            case 0:
                 citys=new String[]{"广州市","韶关市","深圳市","珠海市","汕头市","佛山市","江门市","湛江市","茂名市","肇庆市","惠州市",
                                    "梅州市", "汕尾市","河源市","阳江市","清远市","东莞市","中山市","潮州市","揭阳市","云浮市"};
                 break;
            case 1:
                 citys=new String[]{"福州市","厦门市","莆田市","三明市","泉州市","漳州市","南平市","龙岩市","宁德市"};
                 break;
            case 2:
                citys=new String[]{"杭州市","宁波市","温州市","嘉兴市","湖州市","绍兴市","金华市","衢州市","舟山市","台州市","丽水市"};
                break;
            default:
                citys=new String[]{"...市","...市","...市","...市","...市","...市","...市","...市","...市","...市","...市","...市","...市","...市"};
                break;
        }
        return citys;
    }

    private void  initItemData(){
        ItemData itemData1 = new ItemData("广东");
        array.add(itemData1);
        ItemData itemData2 = new ItemData("福建");
        array.add(itemData2);
        ItemData itemData3 = new ItemData("浙江");
        array.add(itemData3);
        ItemData itemData4 = new ItemData("广西");
        array.add(itemData4);
        ItemData itemData5 = new ItemData("云南");
        array.add(itemData5);
        ItemData itemData6 = new ItemData("湖南");
        array.add(itemData6);
        ItemData itemData7 = new ItemData("湖北");
        array.add(itemData7);
        ItemData itemData8 = new ItemData("河南");
        array.add(itemData8);
        ItemData itemData9 = new ItemData("河北");
        array.add(itemData9);
        ItemData itemData10 = new ItemData("甘肃");
        array.add(itemData10);
        ItemData itemData11 = new ItemData("青岛");
        array.add(itemData11);
        ItemData itemData12 = new ItemData("西藏");
        array.add(itemData12);
        ItemData itemData13 = new ItemData("新疆");
        array.add(itemData13);
        ItemData itemData14 = new ItemData("内蒙古");
        array.add(itemData14);
        ItemData itemData15 = new ItemData("...省");
        array.add(itemData15);
    }
}
