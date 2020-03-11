layui.config({}).extend({
    //加载自定义扩展
    $tool: 'tool',
    $api: 'api',
}).use(['form', 'layer', '$api'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        $ = layui.jquery,

        $api = layui.$api;

    //video背景
    $(window).resize(function () {
        if ($(".video-player").width() > $(window).width()) {
            $(".video-player").css({
                "height": $(window).height(),
                "width": "auto",
                "left": -($(".video-player").width() - $(window).width()) / 2
            });
        } else {
            $(".video-player").css({
                "width": $(window).width(),
                "height": "auto",
                "left": -($(".video-player").width() - $(window).width()) / 2
            });
        }
    }).resize();

    //登录按钮事件
    form.on("submit(login)", function (data) {
        console.log(data.field);
        var req = {
            name: data.field.username,
            pwd: data.field.password,
            code: data.field.code
        };

        $api.Login(req, function (data) {
            //保存用户信息到session中
            window.sessionStorage.setItem("sysUser", data.data.loginName);
            window.sessionStorage.setItem("userId", data.data.userId);
            //登录成功跳转到首页,code !== '0000'的已经在ajaxExtention中统一处理了
            window.location.href = "index.html";
        });

        return false;
    });


});