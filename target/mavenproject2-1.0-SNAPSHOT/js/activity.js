/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function deleteactivity(id){
        if (confirm('Bạn có chắc muốn xóa?')){
            location.assign('DeleteRoutine?acid='+id);
        }
    }
function fillformEditActivity(idrou,act,timebegin,timeend,idatv){
    document.getElementById("activity-edit-idatv").value = idatv;
    document.getElementById("activity-edit-idrou").value = idrou;
    document.getElementById("activity-edit-act").value = act;
    document.getElementById("activity-edit-timebegin").value = timebegin;
    document.getElementById("activity-edit-timeend").value = timeend;
}