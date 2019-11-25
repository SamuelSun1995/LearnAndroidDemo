package cn.weli.learnandroiddemo.Event.Activity.presenter;

import cn.weli.learnandroiddemo.Event.Activity.model.HanlderModel;
import cn.weli.learnandroiddemo.Event.Activity.view.IHandlerView;

public class HandlerPresenter {

    private IHandlerView mView;

    private HanlderModel model;

    public HandlerPresenter(IHandlerView mView) {
        this.mView = mView;
        model = new HanlderModel();
    }

    public void initData() {
        int i = model.getData();
        i++;
        mView.initDataResult(i);
    }
}
