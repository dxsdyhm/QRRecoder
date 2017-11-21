package com.example.user.qrrecoder.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.Toast;

import com.example.user.qrrecoder.R;
import com.example.user.qrrecoder.base.BaseFullScreenActivity;
import com.example.user.qrrecoder.data.greendao.DeviceItem;
import com.example.user.qrrecoder.data.greendaoutil.DBUtils;
import com.example.user.qrrecoder.utils.DeviceUtils;
import com.hdl.elog.ELog;
import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zbar.ZBarView;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;

/**
 * Created by USER on 2017/11/10.
 */

public class ZbarActivity extends BaseFullScreenActivity implements QRCodeView.Delegate {
    @BindView(R.id.zbarview)
    ZBarView zbarview;
    @BindView(R.id.btn_stop)
    Button btnStop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zbar);
        ButterKnife.bind(this);
        initZbar();
    }

    private void initZbar() {
        zbarview.setDelegate(this);
    }

    private void starCamer(){
        zbarview.startSpotDelay(800);
        zbarview.startCamera();
//        zbarview.startCamera(Camera.CameraInfo.CAMERA_FACING_FRONT);
        zbarview.showScanRect();
    }



    @Override
    public void onScanQRCodeSuccess(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        zbarview.startSpotDelay(800);
        result=String.valueOf((int)(Math.random()*100000));
        long time=System.currentTimeMillis();
        if(DeviceUtils.isLegal(result)){
            DeviceItem item=new DeviceItem(result,"1",time, (int) ((Math.random()*1000)%2));
            DeviceItem item1=new DeviceItem(result,"2",time, (int) ((Math.random()*1000)%2));
            DeviceItem item2=new DeviceItem(result,"3",time, (int) ((Math.random()*1000)%2));
            DBUtils.getDeviceItemService().saveOrUpdate(item,item1,item2);
            ELog.dxs("result:"+result);
        }
        vibrate();
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        ELog.dxs("打开相机出错");
    }

    @Override
    protected void onStart() {
        super.onStart();
        starCamer();
    }

    @Override
    protected void onStop() {
        zbarview.stopCamera();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        zbarview.onDestroy();
        super.onDestroy();
    }

    @OnClick(R.id.btn_stop)
    public void onViewClicked() {
        Intent list=new Intent(this,ScanResultActivity.class);
        startActivity(list);
    }
}
