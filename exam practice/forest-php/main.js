var names = [];
var descriptions = [];
var values = [];

function push(){
    let name = this.document.getElementById("name-input").value;
    let desc = this.document.getElementById("description-input").value;
    let value = this.document.getElementById("value-input").value;
    names.push(name);
    descriptions.push(desc);
    values.push(value);

    this.document.getElementById("name-input").value = '';
    this.document.getElementById("description-input").value = '';
    this.document.getElementById("value-input").value = '';
}

function add(userId){
    let ajax = new XMLHttpRequest();
    ajax.onreadystatechange = function () {
        if (this.status === 200) {
            window.location.reload(true);
        }
    }

    ajax.open('POST', 'add.php', true);
    let json = JSON.stringify({'userid':userId,'name': names,'desc':descriptions,'value':values});
    ajax.send(json);
}
