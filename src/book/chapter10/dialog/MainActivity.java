package book.chapter10.dialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button quit,hobby,status,chooseFriend;
	private TextView statusText;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		quit=(Button)findViewById(R.id.quit);//得到按钮
		status=(Button)findViewById(R.id.status);//获取选择状态按钮
		chooseFriend=(Button)findViewById(R.id.chooseFriend);
		statusText=(TextView)findViewById(R.id.statusText);
		hobby=(Button)findViewById(R.id.hobby);
		final Builder builder=new AlertDialog.Builder(this);//创建Builder对象
		
		/*在按钮单击事件中，通过Builder对象来设置对话框的一些属性，包括对话框的内容、按钮等，并通过Builder对象创建和显示对话框*/
		quit.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// builder.setIcon(R.drawable.ic_launcher);
				// builder.setTitle("Are you sure exit?");
				builder.setMessage("Are you sure you want to exit?");//对话框内容
				builder.setCancelable(false);

				//添加Yes按钮
				builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this, "单击了确定！", 1000).show();
					}
				});
				//添加No按钮
				builder.setNegativeButton("No",  new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this, "单击了取消！", 1000).show();
					}
				});
				builder.create().show();//builder.create;可省略
			}
			
		});
		
		//为选择状态按钮添加单击事件处理
		status.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final String [] items=new String[]{"在线","隐身","离开","忙碌","离线","其他"};//列表项
				Builder builder=new AlertDialog.Builder(MainActivity.this);//创建Builder对象
				builder.setTitle("请选择你的状态");//设置对话框的标题
				builder.setIcon(R.drawable.ic_launcher);//设置对话框的图标
				builder.setCancelable(false);//设置对话框不能取消
				builder.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {//设置单选列表，包括列表项、默认选中项、单击事件处理
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						//判断是否选择了“其他”
						if(which==(items.length-1)){
							Builder myBuilder=new Builder(MainActivity.this);//创建Builder对象
							final EditText myInput=new EditText(MainActivity.this);//创建一个文本编辑框
							myBuilder.setTitle("请输入你的状态");//设置对话框标题
							myBuilder.setIcon(R.drawable.ic_launcher);//设置对话框的图标
							myBuilder.setView(myInput);//设置对话框的显示视图
							myBuilder.setPositiveButton("确定",new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
									statusText.setText("你当前的状态是："+myInput.getText().toString());
								}
							});
							myBuilder.show();//创建并显示对话框
						}else{
							statusText.setText("你当前的状态是："+items[which]);
						}
						
					}
				});
				builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub	
					}
				});
				// builder.create().show();
				builder.show();
			}
			
		});
		
		//为你的爱好按钮添加单击事件处理
		hobby.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Builder builder = new AlertDialog.Builder(MainActivity.this);
				final String[] items = new String[] { "旅游", "购物", "文学", "军事","运动", "其他" };
				builder.setTitle("你的爱好有：");
				builder.setIcon(R.drawable.ic_launcher);
				builder.setCancelable(false);
				builder.setMultiChoiceItems(items, null,new DialogInterface.OnMultiChoiceClickListener() {
					public void onClick(DialogInterface dialog,
							int which, boolean isChecked) {
					}
					});
				builder.setPositiveButton("确定",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int which) {
					}
					});
				builder.show();
				}
				});
				
		 //为选择朋友按钮添加单击事件处理
		chooseFriend.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				final String[]names=new String[]{"明天会更好","浅川","萍水相逢"};//昵称数据
				final String[]infos=new String[]{"个性签名：磨剑！","个性签名：拼搏！","个性签名：不求人喜！"};//个性签名数据
				final int[]imageids=new int[]{R.drawable.i1,R.drawable.i2,R.drawable.i3};//头像数据
				List<Map<String,Object>>listItems=new ArrayList<Map<String,Object>>();//创建一个List集合，list集合元素是Map
				for(int i=0;i<names.length;i++){//for循环，将每一项的数据关联起来
					Map<String,Object>map=new HashMap<String,Object>();//创建Map对象，存放每一项数据
					map.put("img", imageids[i]);//将头像放入Map对象
					map.put("title", names[i]);//将昵称放入Map对象
					map.put("info", infos[i]);////将签名放入Map对象
					listItems.add(map);
					}
						
				//创建一个SimpleAdapter
				SimpleAdapter simpleAdapter=new SimpleAdapter(
						MainActivity.this,listItems,R.layout.simple,
						new String[]{"title","info","img"},
						new int[]{R.id.title,R.id.info,R.id.img});
						
				/*然后创建一个对话框，为该对话框设置adapter属性，将adapter数据显示在对话框上，并未对话框添加单击事件处理*/
				Builder myBuilder=new AlertDialog.Builder(MainActivity.this);//创建builder对象
				myBuilder.setTitle("请选择好友");//设置标题
				myBuilder.setIcon(R.drawable.ic_launcher);//设置图标
				myBuilder.setAdapter(simpleAdapter, new DialogInterface.OnClickListener() {//设置列表数据
							
					@Override
					public void onClick(DialogInterface dialog, int which) {//单击事件处理
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this, "你选择的好友是："+names[which], 1000).show();
						}
						});
						myBuilder.create().show();//创建并显示对话框
					}
				});		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		}
}
		
