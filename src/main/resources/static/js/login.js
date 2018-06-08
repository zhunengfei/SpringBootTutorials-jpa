$(function () {
  $('#username').focus(function () {
    $(this).css('outline', '1px solid red');
  });

  $('#username').blur(function () {
    $(this)[0].style.outline = '';
  });
});