/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function deletert(id){
        if (confirm('Bạn có chắc muốn xóa?')){
            location.assign('DeleteRoutine?rid='+id);
        }
    }
function fillformEditRt(id,des){
    document.getElementById("routine-edit-frm").value = des;
    document.getElementById("routine-edit-id").value = id;
}
