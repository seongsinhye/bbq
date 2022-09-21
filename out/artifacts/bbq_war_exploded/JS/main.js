$(function() {
    $('#sub').hide();
    $('#main_nav').hover(function() {
        $(this).parent().find('#sub').slideDown();
        $(this).parent().hover(function() {
            $('#sub').hover(function() {
                $(this).parent().find('#sub').slideDown();
                $(this).parent().hover(function() {
                    
                });
            });
        }, function() {
            $(this).parent().find('#sub').slideUp();
        });
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
        } else {
            $('#fixedNav').removeClass('fixIt');
        }
    });
});