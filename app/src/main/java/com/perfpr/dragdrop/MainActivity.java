package com.perfpr.dragdrop;

import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /**
     * Copy paste job from a tutorial. Will this be the best way to make a drag and drop customer
     * scheduler? I've wasted enough time trying to implement it though racyclerview. This *should*
     * be what I understand SP needs in scheduler, but on a much smaller more detailed level. Don't
     * want to finish that and waste more time if it's not the best way to do this. I feel this many
     * items will lag and cause the system to move slow.
     **/
    private TextView tvJob1, tvJob2, tvJob3, tvJob4, tvJob5, tvJob6, tvJob7, tvEmp1, tvEmp2, tvEmp3;
    private static final String TAG = "DragDropMain";
    String empName, containerText, date, petName, careType, time;
    FloatingActionButton fab;
    List sendList = new ArrayList();
    ArrayList<String[]> addToList;
    Job job;
    int position = 0;
    ArrayList<Job> jobItems = new ArrayList<>();
    boolean previouslyPlaced = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.holder_activity_main);
        //Job que jobs
        tvJob1 = (TextView) findViewById(R.id.tvJob1);
        tvJob2 = (TextView) findViewById(R.id.tvJob2);
        tvJob3 = (TextView) findViewById(R.id.tvJob3);
        tvJob4 = (TextView) findViewById(R.id.tvJob4);
        tvJob5 = (TextView) findViewById(R.id.tvJob5);
        tvJob6 = (TextView) findViewById(R.id.tvJob6);
        tvJob7 = (TextView) findViewById(R.id.tvJob7);
        //Get and set text
        //TODO get Text replace dummy
        //Start boolean
        position = 0;
        previouslyPlaced = false;
        tvJob1.setText("Max\n03-13-17\nWalk");
        tvJob2.setText("Simon\n03-13-17\nWalk");
        tvJob3.setText("Maddie\n03-13-17\nWalk");
        tvJob4.setText("John\n03-14-17\nWalk");
        tvJob5.setText("Cierra\n03-14-17\nWalk");
        tvJob6.setText("Emmy\n03-14-17\nWalk");
        tvJob7.setText("Francine\n03-14-17\nWalk");

        //Employee Names
        tvEmp1 = (TextView) findViewById(R.id.tvEmp1Name);
        tvEmp2 = (TextView) findViewById(R.id.tvEmp2Name);
        tvEmp3 = (TextView) findViewById(R.id.tvEmp3Name);
//      //Import fab
        fab = (FloatingActionButton) findViewById(R.id.fabSave);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
        //Import values
        findViewById(R.id.tvJob1).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.tvJob2).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.tvJob3).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.tvJob4).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.tvJob5).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.tvJob6).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.tvJob7).setOnTouchListener(new MyTouchListener());

        //Job containers
        findViewById(R.id.job1Container).setOnDragListener(new MyDragListener());
        findViewById(R.id.job2Container).setOnDragListener(new MyDragListener());
        findViewById(R.id.job3Container).setOnDragListener(new MyDragListener());
        findViewById(R.id.job4Container).setOnDragListener(new MyDragListener());
        findViewById(R.id.job5Container).setOnDragListener(new MyDragListener());
        findViewById(R.id.job6Container).setOnDragListener(new MyDragListener());
        findViewById(R.id.job7Container).setOnDragListener(new MyDragListener());

        //Emplloyee 1
        findViewById(R.id.e1700Container).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1730Container).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1800Container).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1830Container).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1900Container).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1930Container).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11000Container).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11030Container).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11130Container).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11200Container).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11230Container).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11330Container).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11400Container).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11430Container).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11500Container).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11530Container).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11600Container).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11630Container).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11700Container).setOnDragListener(new MyDragListener());

        //Emplloyee 2
        findViewById(R.id.e1700Containe).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1730Containe).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1800Containe).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1830Containe).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1900Containe).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1930Containe).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11000Containe).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11030Containe).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11130Containe).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11200Containe).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11230Containe).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11330Containe).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11400Containe).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11430Containe).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11500Containe).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11530Containe).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11600Containe).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11630Containe).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11700Containe).setOnDragListener(new MyDragListener());

        //Emplloyee 2
        findViewById(R.id.e1700Contain).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1730Contain).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1800Contain).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1830Contain).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1900Contain).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1930Contain).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11000Contain).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11030Contain).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11130Contain).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11200Contain).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11230Contain).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11330Contain).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11400Contain).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11430Contain).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11500Contain).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11530Contain).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11600Contain).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11630Contain).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11700Contain).setOnDragListener(new MyDragListener());
        //Emplloyee 4
        findViewById(R.id.e1700Contai).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1730Contai).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1800Contai).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1830Contai).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1900Contai).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1930Contai).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11000Contai).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11030Contai).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11130Contai).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11200Contai).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11230Contai).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11330Contai).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11400Contai).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11430Contai).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11500Contai).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11530Contai).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11600Contai).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11630Contai).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11700Contai).setOnDragListener(new MyDragListener());
        //Emplloyee 5
        findViewById(R.id.e1700Conta).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1730Conta).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1800Conta).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1830Conta).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1900Conta).setOnDragListener(new MyDragListener());
        findViewById(R.id.e1930Conta).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11000Conta).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11030Conta).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11130Conta).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11200Conta).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11230Conta).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11330Conta).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11400Conta).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11430Conta).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11500Conta).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11530Conta).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11600Conta).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11630Conta).setOnDragListener(new MyDragListener());
        findViewById(R.id.e11700Conta).setOnDragListener(new MyDragListener());


    }

    private void saveData() {

        Toast.makeText(MainActivity.this, "Entries saved succesfully!", Toast.LENGTH_SHORT).show();
    }

    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                        view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            } else {
                return false;
            }
        }
    }


    class MyDragListener implements View.OnDragListener {
        //Still working on
        Drawable completedShape = getResources().getDrawable(R.drawable.shape_droptarget);
        Drawable exitShape = getResources().getDrawable(R.drawable.time_background);
        Drawable enterShape = getResources().getDrawable(R.drawable.shape_completed);
        Drawable normalShape = getResources().getDrawable(R.drawable.time_background);
        Drawable jobBackground = getResources().getDrawable(R.drawable.job_background);

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothin
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:

                    v.setBackgroundDrawable(completedShape);

                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    v.setBackgroundDrawable(normalShape);


                    break;


                case DragEvent.ACTION_DROP:
                    // Dropped, reassign View to ViewGroup
                    v.setPadding(8, 0, 0, 0);

                    v.setBackground(getResources().getDrawable(R.drawable.shape_droptarget));

                    TextView view = (TextView) event.getLocalState();
                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(view);
                    LinearLayout container = (LinearLayout) v;
                    TextView tv = (TextView) ((LinearLayout) v).getChildAt(0);
                    tv.getLayout().getText().toString();

                    containerText = tv.getText().toString();
                    int containerId = ((LinearLayout) container.getParent()).getId();
                    View contId = (((LinearLayout) container.getParent()).getChildAt(0));
                    String cId1 = String.valueOf(contId.getParent());

                    String s[] = cId1.split("/");
                    String prior = s[0];
                    String result = s[1];
                    String resultFix = result.substring(0, result.length() - 1);
                    if (resultFix.equals("employee1Container")) {
                        empName = "Employee 1";
                    }
                    if (resultFix.equals("employee2Container")) {
                        empName = "Employee 2";
                    }
                    if (resultFix.equals("employee3Container")) {
                        empName = "Employee 3";
                    } else {

                    }

                    Log.d(TAG, result);
                    container.addView(view);
                    view.setVisibility(View.VISIBLE);
                    String ownerText = view.getText().toString();
                    Toast.makeText(MainActivity.this, "Dropped: " + ownerText + "\nOn: " + containerText + "\nAssigned to: " + empName, Toast.LENGTH_SHORT).show();
                    breakDownAndSend(empName, ownerText, containerText);


                    break;

                case DragEvent.ACTION_DRAG_ENDED:

                default:
                    break;
            }
            return true;
        }

        private boolean breakDownAndSend(String empName, String ownerText, String containerText) {

            if (!previouslyPlaced) {
                String[] s = ownerText.split("\n");
                petName = s[0];
                date = s[1];
                careType = s[2];
                time = containerText.toString();
                String[] makeList = {empName, petName, careType, time};
                addToList = new ArrayList<>();
                addToList.add(makeList);

                addToList.add(0, makeList);
                position++;
                Toast.makeText(MainActivity.this, "Succesfully added " + makeList, Toast.LENGTH_SHORT).show();
                previouslyPlaced = true;
                return previouslyPlaced;
            }
            if (previouslyPlaced) {

                for (int i = 0; i < addToList.size(); i++)
                    addToList.remove(i);
                String[] makeList = {empName, petName, careType, date, time};
                addToList.add(makeList);
                Toast.makeText(MainActivity.this, "Successfully updated" + makeList, Toast.LENGTH_SHORT).show();

                return previouslyPlaced;
            } else {
            }
            return previouslyPlaced;
        }
    }
}


