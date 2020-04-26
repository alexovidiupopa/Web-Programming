
function jsonParse(text) {
    let json;
    try {
        json = JSON.parse(text);
    } catch (e) {
        return false;
    }
    return json;
}

/*document.addEventListener('DOMContentLoaded', event => get_filtered_severity(), false);
document.addEventListener('DOMContentLoaded', event => get_filtered_type(), false);*/

function get_filtered_severity() {
    let ajax = new XMLHttpRequest();
    ajax.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let table = document.getElementsByTagName("table")[0];
            let old_tbody = document.getElementsByTagName("tbody")[0];
            let new_tbody = document.createElement('tbody');
            let json = jsonParse(this.responseText);
            for (let i = 0; i < json.length; i++) {
                let report = json[i];
                let row = new_tbody.insertRow();
                console.log(report);
                Object.keys(report).forEach(function (k) {
                    let text;
                    let cell = row.insertCell();
                    text = report[k];
                    cell.appendChild(document.createTextNode(text));
                })
            }
            table.replaceChild(new_tbody, old_tbody);
        }
    }

    ajax.open('POST', 'backend/severity.php', true);
    let severity = (document.getElementsByTagName("select")[0]).value;
    let json = JSON.stringify({'severity': severity});
    ajax.send(json);



}


function get_filtered_type() {
    let ajax = new XMLHttpRequest();

    ajax.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let table = document.getElementsByTagName("table")[1];
            let old_tbody = document.getElementsByTagName("tbody")[1];
            let new_tbody = document.createElement('tbody');
            console.log(this.responseText);
            let json = jsonParse(this.responseText);
            for (let i = 0; i < json.length; i++) {
                let report = json[i];
                let row = new_tbody.insertRow();
                Object.keys(report).forEach(function (k) {
                    let text;
                    let cell = row.insertCell();
                    text = report[k];
                    cell.appendChild(document.createTextNode(text));
                })
            }
            table.replaceChild(new_tbody, old_tbody);
        }
    }
    ajax.open('POST', 'backend/type.php', true);
    let type = document.getElementsByTagName("select")[1].value;
    let json = JSON.stringify({'type': type});
    ajax.send(json);
}
