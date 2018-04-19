var version = new Date().getTime();
requirejs.config({
    baseUrl: '${pageContext.request.contextPath}/js',
    map:{
    	'*':{
    		'css':'require/css.min',
    	}
    },
    paths: {
        'jquery': 'jquery/jquery',
        'bootstrap': 'bootstrap/bootstrap.min',
        'layer': 'layer/layer',
        "jqueryvalidate": "other/validate"
    },
    shim: {
        jquery: {
            exports: 'jquery'
        },
        bootstrap: {
            deps: ['jquery']
        },
        layer: {
            deps: ['jquery']
        },
       
        jqueryvalidate: {
            deps: ['jquery', 'bootstrap']
        },
    },
    //urlArgs: 'version=' + version,
    waitSeconds: 21, //超时时间。设为0禁用等待超时，默认为7秒
})
