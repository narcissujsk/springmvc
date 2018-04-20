'use strict';

requirejs(['jquery', 'bootstrap', 'layer', 'commonUtil', 'nicescroll', 'newscroll'], function ($, bootstrap, layer, commonUtil) {
    $('#sidebar').niceScroll({
        cursorcolor: '#eaedef', //#CC0071 光标颜色
        cursoropacitymax: 0.7, //改变不透明度非常光标处于活动状态（scrollabar“可见”状态），范围从1到0
        touchbehavior: false, //使光标拖动滚动像在台式电脑触摸设备
        cursorwidth: '5px', //像素光标的宽度
        background: 'rgba(0,0,0,0.5)',
        cursorborder: '0', // 游标边框css定义
        cursorborderradius: '5px', //以像素为光标边界半径
        autohidemode: false });
    $.ajaxSetup({cache: false});

    $(document).ajaxComplete(function (event, xhr, settings) {
        checkResponseStatus(xhr.status);
    });
    $(document).ajaxError(function (event, request, settings) {
        // console.info('error:' + event + request + settings);
    });
    $(document).ajaxSuccess(function (event, request, settings) {
        // console.info('success:' + event + request + settings);
        checkResponseStatus(request.status);
    });
    $("button").click(function () {
        $(this).blur();
    })
    var ajaxCnt = 0;
    var layerObj = null;
    var showLoadingDiv = true;
    /*$(document).ajaxStart(function (event, xhr, options) {
     if (!showLoadingDiv) {
     return false;
     }
     // if (ajaxCnt == 0) {
     console.info("loading.......");
     layerObj = layer.load(0, {
     shade: [0.2, '#fff']
     });
     // }
     // ajaxCnt++;
     // console.info("ajaxStart");
     });*/
    $.ajaxPrefilter(function (options, originalOptions, jqXHR) {
        if (!(options.showShade == false)) {
            layerObj = layer.load(0, {
                shade: [0.2, '#fff']
            });
        }
    });
    $(document).ajaxStop(function () {
        if (!showLoadingDiv) {
            return false;
        }
        // ajaxCnt--;
        // if (ajaxCnt == 0){
        setTimeout(function () {
            layer.close(layerObj);
        }, 300);
        // }
    });
    // $( document ).ajaxComplete(function(){
    //     console.info("ajaxComplete");
    // });
    // $( document ).ajaxSend(function(){
    //     console.info("ajaxSend");
    // });
    // $( document ).ajaxSuccess(function(){
    //     console.info("ajaxSuccess");
    // });


    function checkResponseStatus(responseStatus) {
        if (responseStatus == 999) {
            var top = getTopWinow(); //获取当前页面的顶层窗口对象
            //alert('登录超时, 请重新登录.');
            top.location.href = ctx + "/login"; //跳转到登录页面
        }
    }

    var noBarModule = [];
    var modulePath = '../module/';
    noBarModule.push('login/mylogin');
    noBarModule.push('register/register');
    noBarModule.push('register/reg1');
    noBarModule.push('register/reg2');
    noBarModule.push('register/reg3');
    noBarModule.push('register/regFail');
    noBarModule.push('retrievePassword/retrievePwd');
    noBarModule.push('retrievePassword/retrievePwd1');
    noBarModule.push('retrievePassword/retrievePwd2');
    function checkIfInitilizeBarjs(moduleName) {
        // if (noBarModule.includes(moduleName)){
        if (noBarModule.indexOf(moduleName) != -1) {
            return false;
        }
        return true;
    }


    var targetModule = $('#require').attr('target-module');
    if (checkIfInitilizeBarjs(targetModule)) {
        // 页面代码
        requirejs(['leftbar', 'topbar']);
        requirejs(['table']);
    }
    requirejs(['public']);
    if (targetModule) {
        $(function () {

            requirejs([modulePath + targetModule]);
        });
    }

    $(document).on('click', '#breakingnews .close', function (event) {

        $('#breakingnews').css("display", "none");
        $('body').removeClass('hasnotice')
    });

    /**
     * 在页面中任何嵌套层次的窗口中获取顶层窗口
     * @return 当前页面的顶层窗口对象
     */
    function getTopWinow() {
        var p = window;
        while (p != p.parent) {
            p = p.parent;
        }
        return p;
    }

    function isShowLoadingDiv(isShowLoadingDiv) {
        showLoadingDiv = isShowLoadingDiv;
    }

    return {
        isShowLoadingDiv: 'isShowLoadingDiv'
    }

});
