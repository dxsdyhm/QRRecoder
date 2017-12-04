package com.example.user.qrrecoder.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.user.qrrecoder.R;
import com.example.user.qrrecoder.adapter.DeviceItemViewBinder;
import com.example.user.qrrecoder.base.BaseActivity;
import com.example.user.qrrecoder.data.greendao.DeviceItem;
import com.example.user.qrrecoder.data.greendaoauto.DeviceItemDao;
import com.example.user.qrrecoder.data.greendaoutil.DBUtils;
import com.example.user.qrrecoder.entity.UploadRecords;
import com.example.user.qrrecoder.http.Enty.HttpResults;
import com.example.user.qrrecoder.http.retrofit.HttpSend;
import com.example.user.qrrecoder.utils.ToastUtils;
import com.hdl.elog.ELog;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by USER on 2017/11/10.
 */

public class ScanResultActivity extends BaseActivity {
    @BindView(R.id.recy_deviceitem)
    RecyclerView recyDeviceitem;
    @BindView(R.id.fab_upload)
    FloatingActionButton fabUpload;
    private MultiTypeAdapter adapter;
    private Items items;
    private List<DeviceItem> deviceItems;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        mContext=this;
        initData();
    }

    @Override
    protected int getConstomLayout() {
        return R.layout.activity_scanresult;
    }

    @Override
    public void setToolBarTitle() {
        if (toolbar != null) {
            toolbar.setTitle(R.string.scan_result);
        }
    }

    private void initData() {
        adapter = new MultiTypeAdapter();
        /* 注册类型和 View 的对应关系 */
        adapter.register(DeviceItem.class, new DeviceItemViewBinder());
        recyDeviceitem.setLayoutManager(new LinearLayoutManager(this));
        recyDeviceitem.setAdapter(adapter);

        items = new Items();
        QueryBuilder<DeviceItem> builder = DBUtils.getDeviceItemService().queryBuilder();
//        builder.where(DeviceItemDao.Properties.Faccount.eq("dxs"));
        builder.orderDesc(DeviceItemDao.Properties.Fscantime);
        deviceItems=builder.list();
        items.addAll(deviceItems);
        ELog.dxs("size:" + items.size());

        adapter.setItems(items);
        adapter.notifyItemRangeChanged(0, items.size() - 1);

    }

    private MaterialDialog.Builder builder;
    private void createDialog(){
        builder = new MaterialDialog.Builder(this)
                .title(R.string.app_name)
                .content(R.string.scan_uploading)
                .progress(true,0);
    }

    @OnClick(R.id.fab_upload)
    public void onViewClicked() {
        createDialog();
        final MaterialDialog dialog = builder.build();
        Observer<String> observer =new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                dialog.show();
            }

            @Override
            public void onNext(String stringHttpResults) {
                String toast=String.format(mContext.getString(R.string.upload_success),stringHttpResults);
                ToastUtils.ShowSuccess(mContext,toast);
            }


            @Override
            public void onError(Throwable e) {
                dialog.dismiss();
                ToastUtils.ShowError(mContext,e.toString(),1500,false);
            }

            @Override
            public void onComplete() {
                dialog.dismiss();
            }
        };
        UploadRecords records=new UploadRecords("1",deviceItems);
        HttpSend.getInstence().uploadRecord(records,observer);
    }
}
