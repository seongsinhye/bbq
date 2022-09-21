$(document).ready(function () {

    $("#coupon").hide();
    $("#point").hide();
    $("#card").hide();
    $("#ask").hide();
    $("#info").hide();

    $("#myOrder").css('cursor', 'pointer');
    $("#myOrder").css('cursor', 'pointer');
    $("#myCoupon").css('cursor', 'pointer');
    $("#myPoint").css('cursor', 'pointer');
    $("#myCard").css('cursor', 'pointer');
    $("#myAsk").css('cursor', 'pointer');
    $("#myMembership").css('cursor', 'pointer');
    
    $("#myOrder").css('color', 'black');

    $("#myOrder").on('click', function(){
        $("#myOrder").css('color', 'black');
        $("#myCoupon").css('color', 'rgb(145, 145, 145)');
        $("#myPoint").css('color', 'rgb(145, 145, 145)');
        $("#myCard").css('color', 'rgb(145, 145, 145)');
        $("#myAsk").css('color', 'rgb(145, 145, 145)');
        $("#myMembership").css('color', 'rgb(145, 145, 145)');

        $("#buylist").show();
        $("#coupon").hide();
        $("#point").hide();
        $("#card").hide();
        $("#ask").hide();
        $("#info").hide();
    })

    $("#myCoupon").on('click', function(){
        $("#myOrder").css('color', 'rgb(145, 145, 145)');
        $("#myCoupon").css('color', 'black');
        $("#myPoint").css('color', 'rgb(145, 145, 145)');
        $("#myCard").css('color', 'rgb(145, 145, 145)');
        $("#myAsk").css('color', 'rgb(145, 145, 145)');
        $("#myMembership").css('color', 'rgb(145, 145, 145)'); 

        $("#buylist").hide();
        $("#coupon").show();
        $("#point").hide();
        $("#card").hide();
        $("#ask").hide();
        $("#info").hide();
    })

    $("#myPoint").on('click', function(){
        $("#myOrder").css('color', 'rgb(145, 145, 145)');
        $("#myCoupon").css('color', 'rgb(145, 145, 145)');
        $("#myPoint").css('color', 'black');
        $("#myCard").css('color', 'rgb(145, 145, 145)');
        $("#myAsk").css('color', 'rgb(145, 145, 145)');
        $("#myMembership").css('color', 'rgb(145, 145, 145)'); 

        $("#buylist").hide();
        $("#coupon").hide();
        $("#point").show();
        $("#card").hide();
        $("#ask").hide();
        $("#info").hide();
    })

    $("#myCard").on('click', function(){
        $("#myOrder").css('color', 'rgb(145, 145, 145)');
        $("#myCoupon").css('color', 'rgb(145, 145, 145)');
        $("#myPoint").css('color', 'rgb(145, 145, 145)');
        $("#myCard").css('color', 'black');
        $("#myAsk").css('color', 'rgb(145, 145, 145)');
        $("#myMembership").css('color', 'rgb(145, 145, 145)'); 

        $("#buylist").hide();
        $("#coupon").hide();
        $("#point").hide();
        $("#card").show();
        $("#ask").hide();
        $("#info").hide();
    })

    $("#myAsk").on('click', function(){
        $("#myOrder").css('color', 'rgb(145, 145, 145)');
        $("#myCoupon").css('color', 'rgb(145, 145, 145)');
        $("#myPoint").css('color', 'rgb(145, 145, 145)');
        $("#myCard").css('color', 'rgb(145, 145, 145)');
        $("#myAsk").css('color', 'black');
        $("#myMembership").css('color', 'rgb(145, 145, 145)'); 

        $("#buylist").hide();
        $("#coupon").hide();
        $("#point").hide();
        $("#card").hide();
        $("#ask").show();
        $("#info").hide();
    })

    $("#myMembership").on('click', function(){
        $("#myOrder").css('color', 'rgb(145, 145, 145)');
        $("#myCoupon").css('color', 'rgb(145, 145, 145)');
        $("#myPoint").css('color', 'rgb(145, 145, 145)');
        $("#myCard").css('color', 'rgb(145, 145, 145)');
        $("#myAsk").css('color', 'rgb(145, 145, 145)');
        $("#myMembership").css('color', 'black'); 

        $("#buylist").hide();
        $("#coupon").hide();
        $("#point").hide();
        $("#card").hide();
        $("#ask").hide();
        $("#info").show();
    })

    $(function() {
        $('#sub').hide();
        $('#navMain').mouseenter(function() {
            $('#sub').slideDown();

        });
        $('#navMain').mouseleave(function() {
            $('#sub').slideUp(); 
        });
    });
    
    $(document).ready(function() {
         $('.slider').bxSlider();
    });
    
    function moveToTop() {
        window.scrollTo(0,0);
    }
    
    $(document).ready(function () {
        var fixedScroll = $('#fixedNav').offset();
        $(window).scroll(function() {
            if($(document).scrollTop() > fixedScroll.top) {
                $('#fixedNav').addClass('fixIt');
                $('#navFront2').css('right', '10px');
                
            } else {
                $('#fixedNav').removeClass('fixIt');
                $('#navFront2').css('right', '300px');
                
            }
        });
    });
    
});