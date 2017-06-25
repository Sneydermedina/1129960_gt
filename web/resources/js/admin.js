$(document).ready(function () {
    $('#btnPopover').popover();
});
$(function () {
    $('[data-toggle="popover"]').popover()
})
$('[rel="popover"]').popover({
    trigger: 'focus',
    html: true,
    delay: 500,
});
$(function () {
    $('[data-toggle="tooltip"]').tooltip()
})