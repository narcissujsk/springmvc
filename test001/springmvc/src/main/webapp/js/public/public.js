define(['jquery', 'layer','bootstrap', 'jqplug', 'newscroll'], function($,layer) {


    var $win = $(window),
        $doc = $(document),
        $body = $(document.body);
    $(function() {
        $('input.j-placeholder').placeholder();
        //鼠标放上展示隐藏
        $('.j-hover').hover(function() {
            $('.j-hover-content').show()

        }, function() {
            $('.j-hover-content').hide()

        })
        $doc.on('click', '.j-btn-opmore', function(event) {

            $('.j-opcon').hide();
            $(this).parent().find('.j-opcon').toggle();
        });
        $doc.on('mouseleave ', '.oplist-more', function(event) {
            $(this).find('.j-opcon').hide();
        })
        $doc.on('click', '.j-subtn', function() {
            var subval = $(this).parent().find('.input-num');
            if (parseInt(subval.val()) > 1)
                subval.val(parseInt(subval.val()) - 1)
        });

        $doc.on('click', '.j-addbtn', function() {
            var subval = $(this).parent().find('.input-num');
            subval.val(parseInt(subval.val()) + 1);
        });
        $doc.on('keydown', '.j-subadd-input', function() {
            if (!(event.keyCode == 46) && !(event.keyCode == 8) && !(event.keyCode == 37) && !(event.keyCode == 39))
                if (!((event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 96 && event.keyCode <= 105)))
                    event.returnValue = false;
        });
        $doc.on('click', '.j-item-toggle li', function(event) {

            if (!$(this).hasClass('disable')) {
                $(this).addClass('active').siblings().removeClass('active');
            }
        });
        // select
        $('.j-select dt').click(function(e) {
            e.stopPropagation();
            $('.j-select dd').hide();
            $('.j-select').css('z-index', '1');
            $(this).parent().find('dd').show();

            $(this).parent().css('z-index', '99999999');
            // autoSelectWidth($(this));
        });

        function autoSelectWidth(obj) {
            var dtWidth = obj.parent('dl').width();
            var ddWidth = obj.parent().find('dd').width() + 2;

            // alert(dtWidth + "" + ddWidth);
            if (dtWidth > ddWidth) {

                obj.css('width', dtWidth);
                obj.parent().find('dd').width(dtWidth - 2);

            } else {
                obj.css('width', ddWidth);
                obj.parent().find('dd').width(ddWidth - 2)

            }
        }
        $('.j-select dd .j-item').click(function(e) {
            $(this).addClass('selected').siblings().removeClass('selected');

            $(this).parents('.j-select').find('dt .select-text').html($(this).html());

            $(this).parents('.j-select dd').hide();
            $(this).parents('.j-select').css('z-index', '1');

        });

        $('.j-select').mouseleave(function() {
            $(this).find('dd').hide();
            $(this).css({
                'z-index': '1'
            });
        })

    })

    var aboutLay = null;
    $doc.on('click', '#topAbout', function(event) {
    	aboutLay = layer.open({
            type: 1,
            title: '关于',
            skin: 'layui-layer-lan',
            area: ['570px'], //
            shadeClose: true, //点击遮罩关闭
            content: $('#layerTopAbout')
        });
    });
    
    $doc.on('click','#layerTopAbout',function(){    	
    	if (aboutLay != null){
    		layer.close(aboutLay);
    	}    	
    });
    
    
    
});
