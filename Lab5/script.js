$(document).ready(function(){
    
    var picWidth = 200;
    var poz = 0;		
    var popupDiv = document.getElementById("popup-id");
    var popupImg = document.getElementById("popup-img");

    $("li").each(function() {    
            poz += picWidth;
            $(this).css("left",poz);    
    });

    $("img").click(function(){
       var img = $(this).attr('src');
       popupDiv.style.display = 'block';
       popupImg.src = img; 
       $("li").clearQueue();
       $("li").stop(); 
    });

    popupImg.onclick = function() {
    popupDiv.style.display = 'none';  
    slide();
    } 
    function slide() {
        $("li").animate({"left":"+=15px"}, 'fast', repeat);
    }
    function repeat() {
        var left = $(this).parent().offset().left + $(this).offset().left;
        if (left >= 1600) {
            $(this).css("left",left - 1600);
        }
        slide();
    }

    slide();
});