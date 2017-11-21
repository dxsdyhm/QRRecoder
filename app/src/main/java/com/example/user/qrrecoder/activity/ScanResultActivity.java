package com.example.user.qrrecoder.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.qrrecoder.R;
import com.example.user.qrrecoder.adapter.DeviceItemViewBinder;
import com.example.user.qrrecoder.base.BaseActivity;
import com.example.user.qrrecoder.data.greendao.DeviceItem;
import com.example.user.qrrecoder.data.greendao.User;
import com.example.user.qrrecoder.data.greendaoauto.DeviceItemDao;
import com.example.user.qrrecoder.data.greendaoauto.UserDao;
import com.example.user.qrrecoder.data.greendaoutil.DBUtils;
import com.hdl.elog.ELog;

import org.greenrobot.greendao.query.QueryBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by USER on 2017/11/10.
 */

public class ScanResultActivity extends BaseActivity {
    @BindView(R.id.recy_deviceitem)
    RecyclerView recyDeviceitem;
    private MultiTypeAdapter adapter;
    private Items items;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanresult);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        adapter = new MultiTypeAdapter();
        /* 注册类型和 View 的对应关系 */
        adapter.register(DeviceItem.class, new DeviceItemViewBinder());
        recyDeviceitem.setLayoutManager(new LinearLayoutManager(this));
        recyDeviceitem.setAdapter(adapter);

        items = new Items();
        QueryBuilder<DeviceItem> builder=DBUtils.getDeviceItemService().queryBuilder();
        builder.where(DeviceItemDao.Properties.Userid.eq("1"));
        builder.orderDesc(DeviceItemDao.Properties.Recordtime);
        items.addAll(builder.list());
        ELog.dxs("size:"+items.size());

        adapter.setItems(items);
        adapter.notifyItemRangeChanged(0,items.size()-1);
    }
}
