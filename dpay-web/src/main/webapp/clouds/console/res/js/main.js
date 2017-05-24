$(function(){
    $('.serv-fenl').mouseenter(function(){
        $(this).siblings().find('.sevrjs').stop().animate({left:"233"+'px'});
        $(this).find('.sevrjs').stop().animate({left:"0"});
        
    })
    $('.serv-fenl').mouseleave(function(){
        $(this).parent().find('.sevrjs').stop().animate({left:"233"+'px'});
    })
    // tab切换-即将开展
    $('.showTab:first').show()
    $('.startBT h4 a').click(function(){
		$(this).attr('class','act').siblings().removeClass('act')
		var index=$(this).index()+1;
		$('.showTab:nth-child('+index+')').show().siblings().hide()
	})
	// tab切换-行业会展
	$('.hot-show-list:first').show()
    $('#hot-showing-list .startBT h4 a').click(function(){
		$(this).attr('class','act').siblings().removeClass('act')
		var index=$(this).index()+1;
		$('.hot-show-list:nth-child('+index+')').show().siblings().hide()
	})
    // 推荐滚动
    
	$window1 = $(".servshow");
	$window2 = $(".servshow2");
	$li1 = $window1.find(".serv-fenl");
	$li2 = $window2.find(".serv-fenl");
	$window1.css("width", $li1.length*234);
	$window2.css("width", $li2.length*234);
	var lc1 = 0;
	var rc1 = $li1.length-5;
	var lc2 = 0;
	var rc2 = $li2.length-5;
	$('.prev').click(function(){
		if (lc1 < 1) {
			$(this).attr('disable','true')
			return;
		}
		lc1--;
		rc1++;
		$window1.animate({left:'+=233px'}, 1000);
	});

	$('.next').click(function(){
		if (rc1 < 1){
			$(this).attr('disable','true')
			return;
		}
		lc1++;
		rc1--;
		$window1.animate({left:'-=233px'}, 1000);
	});
	$('.prev1').click(function(){
		if (lc2 < 1) {
			$(this).attr('disable','true')
			return;
		}
		lc2--;
		rc2++;
		$window2.animate({left:'+=233px'}, 1000);
	});

	$('.next1').click(function(){
		if (rc2 < 1){
			$(this).attr('disable','true')
			return;
		}
		lc2++;
		rc2--;
		$window2.animate({left:'-=233px'}, 1000);
	});

	// 子banner
	$window5 = $(".subbanshow");
	$li5 = $window5.find(".subban1");
	$window5.css("width", $li5.length*292);
	var lc5 = 0;
	var rc5 = $li5.length-4;
	
	$('.prev5').click(function(){

		if (lc5 < 1) {
			$(this).attr('disable','true')
			return;
		}
		lc5--;
		rc5++;
		$window5.animate({left:'+=292px'}, 500);
	});

	$('.next5').click(function(){
		if (rc5 < 1){
			$(this).attr('disable','true')
			return;
		}
		lc5++;
		rc5--;
		$window5.animate({left:'-=292px'}, 500);
	});
	//行业会展多选择
	 $(".financing-form-list-content-more").on("click",function(){
        val=$(this).parent().next().css("overflow");
        // alert(val);
        if(val=="hidden"){
            $(this).parent().next().css("height","auto");
            $(this).parent().next().css("overflow","auto");
            $(this).text('全部').css('color',"#d71921")
        }
        else{
            $(this).parent().next().css("height","36px");
            $(this).parent().next().css("overflow","hidden");
            $(this).text('展开').css('color',"#000")

        }
        $(document).on("click",".financing-form-list-content a",function(){


        })
    })
	 // 返回顶部
	   $(window).scroll(function() {
        if ($(window).scrollTop() > 800)
            $('.rightadress').fadeIn();
        else
	        $('.rightadress').fadeOut();
	    });
	    $('#return').click(function() {
	        $('html, body').animate({scrollTop: 0}, 1000);
	    });
	 // 首页返回顶部
	    $(window).scroll(function() {
        if ($(window).scrollTop() > 400)
            $('.gotop').fadeIn();
        else
	        $('.gotop').fadeOut();
	    });
	    $('#return').click(function() {
	        $('html, body').animate({scrollTop: 0}, 1000);
	    });

	   // 会展服务
	   $('.sevice li').click(function(){
	   		var index=$(this).index()+1;
			$('.mcr2-content:nth-child('+index+')').show().siblings().hide()
	   })

    // 帮助中心
    var Accordion = function(el, multiple) {
        this.el = el || {};
        this.multiple = multiple || false;

        // Variables privadas
        var links = this.el.find('.link');
        // Evento
        links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
    }

    Accordion.prototype.dropdown = function(e) {
        var $el = e.data.el;
        $this = $(this),
        $next = $this.next();

        $next.slideToggle();
        $this.parent().toggleClass('open');

        if (!e.data.multiple) {
            $el.find('.submenu').not($next).slideUp().parent().removeClass('open');
        };
    }

    var accordion = new Accordion($('#accordion'), false);
    // 帮助中心2
    var Accordion = function(el, multiple) {
        this.el = el || {};
        this.multiple = multiple || false;

        // Variables privadas
        var links = this.el.find('.link2');
        // Evento
        links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
    }

    Accordion.prototype.dropdown = function(e) {
        var $el = e.data.el;
        $this = $(this),
            $next = $this.next();

        $next.slideToggle();
        $this.parent().toggleClass('open');

        if (!e.data.multiple) {
            $el.find('.submenu2').not($next).slideUp().parent().removeClass('open');
        };
    }

    var accordion = new Accordion($('#accordion2'), false);

	// 展会列表
	var Accordion = function(el, multiple) {
		this.el = el || {};
		this.multiple = multiple || false;

		// Variables privadas
		var links = this.el.find('.link3');
		// Evento
		links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
	}

	Accordion.prototype.dropdown = function(e) {
		var $el = e.data.el;
			$this = $(this),
			$next = $this.next();

		$next.slideToggle();
		$this.parent().toggleClass('open');

		if (!e.data.multiple) {
			$el.find('.submenu3').not($next).slideUp().parent().removeClass('open');
		};
	}	

	var accordion = new Accordion($('#accordion3'), false);

})

