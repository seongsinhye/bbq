$(document).ready(function() {
    $('#checkAll').click(function() {
    if ($('#checkAll').prop("checked")) {
        $('.check').prop("checked", true);
    }
    else $('.check').prop("checked", false);
    });
});