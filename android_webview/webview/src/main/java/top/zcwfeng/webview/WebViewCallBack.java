package top.zcwfeng.webview;

public
interface WebViewCallBack {
    void pageStarted(String url);
    void pageFinished(String url);
    void onError();
    void updateTitle(String title);

}
