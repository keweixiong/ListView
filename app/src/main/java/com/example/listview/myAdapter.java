package com.example.listview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.List;



public class myAdapter extends ArrayAdapter {

    private final int idListviewLayoutXml;
    private RadioButton radioButton1;

    public myAdapter(Context context, int listviewMyLayoutXml, List<myBean> listviewMyData) {
        super(context, listviewMyLayoutXml, listviewMyData);

        idListviewLayoutXml = listviewMyLayoutXml;//这个是传入我们自己定义的list view xml界面
    }


    public View getView(final int position, final View convertView, ViewGroup parent) {

        myBean myBean = (myBean) getItem(position);  // get one item
        final View viewInstance;
        final ViewHolder viewHolder;

        if (convertView == null) {  //it is a new one,let is prepare it 当concertView为空的时候才绘制一个View
            viewInstance = LayoutInflater.from(getContext()).inflate(idListviewLayoutXml, parent,false );//这个是实例化一个我们自己写的界面Item
            viewHolder = new ViewHolder();
            viewHolder.listviewLayout = viewInstance.findViewById(R.id.ll_view);
            viewHolder.fruitImage = viewInstance.findViewById(R.id.iditemimage);
            viewHolder.fruitText = viewInstance.findViewById(R.id.iditemtext);
            viewHolder.fruitRadioGroup = viewInstance.findViewById(R.id.radioBtnGroup);

            viewInstance.setTag(viewHolder);//为空时把新内容存放在Tag里

        }
        else {  //  get the original info
            viewInstance = convertView;
            viewHolder = (ViewHolder)viewInstance.getTag();
        }
        Log.e("abc","abc");

 //       final RadioGroup radiogroup = view.findViewById(R.id.radioBtnGroup);
 // Log.e("abc",myBean.getImageID().toString());

        viewHolder.fruitImage.setImageResource(myBean.getImageID());
        viewHolder.fruitText.setText(myBean.getText());

        viewHolder.fruitRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {//检查Radio Button那个被点击了
            public void onCheckedChanged(RadioGroup radioGroup,   int i) {
                 radioButton1 = viewHolder.listviewLayout.findViewById(i);
                 Toast.makeText(getContext(), "CheckedChanged listen " + position + "项" + radioButton1.getText()+"你选择" , Toast.LENGTH_SHORT).show();

            }
        });


 /*       viewHolder.fruitLayout.setOnClickListener(new View.OnClickListener() {//检查哪一项被点击了
            @Override
            public void onClick(View view) {
                for (int i = 0; i< viewHolder.fruitRadioGroup.getChildCount(); i++) {
                    RadioButton rrr = (RadioButton) viewHolder.fruitRadioGroup.getChildAt(i);
                    if (rrr.isChecked()){
                        Toast.makeText(getContext(), " onClick listen 你点击了第" + position + "项" + "你选择" + rrr.getText(), Toast.LENGTH_SHORT).show();

                        break;
                    }
                }
            }
        });
 */       return viewInstance;
    }


}