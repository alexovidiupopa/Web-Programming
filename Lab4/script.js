window.onload = ()=>{
    //console.log("page loaded");
    var tableCells = document.getElementsByClassName("ph");  

    let first = "";
    let second = "";
    let count = 0;
 
    var check = function () {
        let result="";
        let images = document.getElementsByTagName("img");
        for (let image of images){
            result+=image.getAttribute("id")[0] + "";
        }
        return result=="123456789";
    }

    var swap = function () {
        if (!first){
            first = this.getAttribute("id")[0];
            console.log(first);
        }
        count++;
        if (count>1 && first){
            second=this.getAttribute("id")[0];
            console.log(second);
        }

        if (first){
            document.getElementById("first").innerText = document.getElementById(first).getElementsByTagName("img")[0].getAttribute("id");
        }

        if (second){
            document.getElementById("second").innerText = document.getElementById(second).getElementsByTagName("img")[0].getAttribute("id");
        }

        if (first && second && first != second) {
            let firstTD = document.getElementById(first);
            let secondTD = document.getElementById(second);
            let x = firstTD.childNodes[0];
            let y = secondTD.childNodes[0];
        
        //   console.log(firstTD);
        //   console.log(y);
            firstTD.removeChild(firstTD.childNodes[0]);
            secondTD.removeChild(secondTD.childNodes[0]);
    
            firstTD.appendChild(y);
            secondTD.appendChild(x);
            
            count = 0;
            first = "";
            second = "";
      
            if (check()){
                document.getElementById("win").innerText = "Well done!";
                //alert("Well done!");
            }
        }
    };
    
    for (let i=0;i<tableCells.length;i++){
        tableCells[i].addEventListener('click', swap);
        // console.log("here");
    }
}