package com.nazran.worldcup2018androidfive.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.nazran.worldcup2018androidfive.Adapters.NotificationListAdapter;
import com.nazran.worldcup2018androidfive.ModelClasses.NotificationItem;
import com.nazran.worldcup2018androidfive.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationsActivity extends AppCompatActivity {

    private ListView teamsListView;
    private List<NotificationItem> dataList = new ArrayList<NotificationItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        teamsListView = findViewById(R.id.teamsListView);

        makeDataList();

        NotificationListAdapter adapter =
                new NotificationListAdapter(NotificationsActivity.this, dataList);
        teamsListView.setAdapter(adapter);

    }

    private void makeDataList() {
        NotificationItem item = new NotificationItem("https://pbs.twimg.com/profile_images/875443327835025408/ZvmtaSXW_400x400.jpg",
                "Argentina", true);
        dataList.add(item);

        item = new NotificationItem("http://icons.iconarchive.com/icons/custom-icon-design/flag-3/256/Brazil-Flag-icon.png",
                "Brazil", false);
        dataList.add(item);

        item = new NotificationItem("https://cdn2.iconfinder.com/data/icons/all-in-one-country-flag-2/256/Germany-flag.png",
                "Germany", true);
        dataList.add(item);
    }
}
