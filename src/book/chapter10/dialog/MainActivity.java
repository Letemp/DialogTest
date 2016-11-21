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
		
		quit=(Button)findViewById(R.id.quit);//�õ���ť
		status=(Button)findViewById(R.id.status);//��ȡѡ��״̬��ť
		chooseFriend=(Button)findViewById(R.id.chooseFriend);
		statusText=(TextView)findViewById(R.id.statusText);
		hobby=(Button)findViewById(R.id.hobby);
		final Builder builder=new AlertDialog.Builder(this);//����Builder����
		
		/*�ڰ�ť�����¼��У�ͨ��Builder���������öԻ����һЩ���ԣ������Ի�������ݡ���ť�ȣ���ͨ��Builder���󴴽�����ʾ�Ի���*/
		quit.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// builder.setIcon(R.drawable.ic_launcher);
				// builder.setTitle("Are you sure exit?");
				builder.setMessage("Are you sure you want to exit?");//�Ի�������
				builder.setCancelable(false);

				//���Yes��ť
				builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this, "������ȷ����", 1000).show();
					}
				});
				//���No��ť
				builder.setNegativeButton("No",  new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this, "������ȡ����", 1000).show();
					}
				});
				builder.create().show();//builder.create;��ʡ��
			}
			
		});
		
		//Ϊѡ��״̬��ť��ӵ����¼�����
		status.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final String [] items=new String[]{"����","����","�뿪","æµ","����","����"};//�б���
				Builder builder=new AlertDialog.Builder(MainActivity.this);//����Builder����
				builder.setTitle("��ѡ�����״̬");//���öԻ���ı���
				builder.setIcon(R.drawable.ic_launcher);//���öԻ����ͼ��
				builder.setCancelable(false);//���öԻ�����ȡ��
				builder.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {//���õ�ѡ�б������б��Ĭ��ѡ��������¼�����
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						//�ж��Ƿ�ѡ���ˡ�������
						if(which==(items.length-1)){
							Builder myBuilder=new Builder(MainActivity.this);//����Builder����
							final EditText myInput=new EditText(MainActivity.this);//����һ���ı��༭��
							myBuilder.setTitle("���������״̬");//���öԻ������
							myBuilder.setIcon(R.drawable.ic_launcher);//���öԻ����ͼ��
							myBuilder.setView(myInput);//���öԻ������ʾ��ͼ
							myBuilder.setPositiveButton("ȷ��",new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
									statusText.setText("�㵱ǰ��״̬�ǣ�"+myInput.getText().toString());
								}
							});
							myBuilder.show();//��������ʾ�Ի���
						}else{
							statusText.setText("�㵱ǰ��״̬�ǣ�"+items[which]);
						}
						
					}
				});
				builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub	
					}
				});
				// builder.create().show();
				builder.show();
			}
			
		});
		
		//Ϊ��İ��ð�ť��ӵ����¼�����
		hobby.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Builder builder = new AlertDialog.Builder(MainActivity.this);
				final String[] items = new String[] { "����", "����", "��ѧ", "����","�˶�", "����" };
				builder.setTitle("��İ����У�");
				builder.setIcon(R.drawable.ic_launcher);
				builder.setCancelable(false);
				builder.setMultiChoiceItems(items, null,new DialogInterface.OnMultiChoiceClickListener() {
					public void onClick(DialogInterface dialog,
							int which, boolean isChecked) {
					}
					});
				builder.setPositiveButton("ȷ��",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int which) {
					}
					});
				builder.show();
				}
				});
				
		 //Ϊѡ�����Ѱ�ť��ӵ����¼�����
		chooseFriend.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				final String[]names=new String[]{"��������","ǳ��","Ƽˮ���"};//�ǳ�����
				final String[]infos=new String[]{"����ǩ����ĥ����","����ǩ����ƴ����","����ǩ����������ϲ��"};//����ǩ������
				final int[]imageids=new int[]{R.drawable.i1,R.drawable.i2,R.drawable.i3};//ͷ������
				List<Map<String,Object>>listItems=new ArrayList<Map<String,Object>>();//����һ��List���ϣ�list����Ԫ����Map
				for(int i=0;i<names.length;i++){//forѭ������ÿһ������ݹ�������
					Map<String,Object>map=new HashMap<String,Object>();//����Map���󣬴��ÿһ������
					map.put("img", imageids[i]);//��ͷ�����Map����
					map.put("title", names[i]);//���ǳƷ���Map����
					map.put("info", infos[i]);////��ǩ������Map����
					listItems.add(map);
					}
						
				//����һ��SimpleAdapter
				SimpleAdapter simpleAdapter=new SimpleAdapter(
						MainActivity.this,listItems,R.layout.simple,
						new String[]{"title","info","img"},
						new int[]{R.id.title,R.id.info,R.id.img});
						
				/*Ȼ�󴴽�һ���Ի���Ϊ�öԻ�������adapter���ԣ���adapter������ʾ�ڶԻ����ϣ���δ�Ի�����ӵ����¼�����*/
				Builder myBuilder=new AlertDialog.Builder(MainActivity.this);//����builder����
				myBuilder.setTitle("��ѡ�����");//���ñ���
				myBuilder.setIcon(R.drawable.ic_launcher);//����ͼ��
				myBuilder.setAdapter(simpleAdapter, new DialogInterface.OnClickListener() {//�����б�����
							
					@Override
					public void onClick(DialogInterface dialog, int which) {//�����¼�����
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this, "��ѡ��ĺ����ǣ�"+names[which], 1000).show();
						}
						});
						myBuilder.create().show();//��������ʾ�Ի���
					}
				});		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		}
}
		
