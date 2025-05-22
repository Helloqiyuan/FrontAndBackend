//新增数据函数
function addRow(){
    var table1 = document.getElementById("table1");
    // console.log(table1);
    
    //首先获取这个表有多少行
    var length = table1.rows.length;
    // console.log(length);
    
    //插入行节点
    var newRow = table1.insertRow(length);
    // console.log(newRow);
    var nameCol = newRow.insertCell(0);
    var phoneCol = newRow.insertCell(1);
    var opCol = newRow.insertCell(2);
      
    //修改节点文本内容
    nameCol.innerHTML = "N" + length;
    phoneCol.innerHTML = "P" + length;
    opCol.innerHTML = '<button onclick="editRow(this)">编辑</button>&nbsp;<button onclick="deleteRow(this)">删除</button>';

}

//删除数据函数
function deleteRow(params){
    // console.log(params);
    var row = params.parentNode.parentNode;
    console.log(row);
    row.parentNode.removeChild(row);
    
}

//编辑数据函数
function editRow(params){
    // console.log(params);
    
    var row = params.parentNode.parentNode;

    var Name = row.cells[0];    
    var Phone = row.cells[1];
    
    var inputName = prompt("名字:");
    var inputPhone = prompt("电话号码:");

    Name.innerText = inputName;
    Phone.innerText = inputPhone;
}

//查询数据
function findRow(){
    var findName = prompt("输入名字或者电话号码:");
    var table = document.getElementById("table1");
    var length = table.rows.length;
    var row = table.rows;
    // console.log(row);
    for(var i = 0;i < length;i++){
        row[i].style.backgroundColor = "";
    }
    var i;
    for(i = 1;i < length;i++){
        var nameCell = row[i].cells[0].textContent;
        var PhoneCell = row[i].cells[1].textContent;
        if(nameCell == findName || PhoneCell == findName){
            // 高亮显示
            row[i].style.backgroundColor = "#ffeb3b";
            // 添加锚点ID
            row[i].id = `match-${i}`;
            
            // 跳转到该行（平滑滚动）
            row[i].scrollIntoView({
                behavior: "smooth",
                block: "center"
            });
            break;
        }
    }
    if(i == length){
        alert("没找到");
    }
}

for(var i = 0;i < 100;i++){
    addRow();
}