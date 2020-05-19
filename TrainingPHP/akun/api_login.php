<?php
/**
 * Created by PhpStorm.
 * User: lenovo
 * Date: 7/7/2019
 * Time: 8:28 PM
 */

include "../config.php";

if ($_GET){

    $nik_user = $_GET['nik_user'];
    $password = $_GET['password'];

    $sql = mysqli_query($db, "Select * from akun where nik_user = '$nik_user' and password = '$password'");
    $user = mysqli_fetch_assoc($sql);

    $id_account = "".$user['id_user'];
    $nik_user = "".$user['nik_user'];
    $rule = "".$user['rule'];

    if ($sql) {
        $response["error"] = false;
        $response["error_msg"] = "Berhasil Login";
        $response["id"] = $id_account;
        $response["username"] = $nik_user;
        $response["rule"] = $rule;
        echo json_encode($response);
    } else{
        $response["error"] = false;
        $response["error_msg"] = "Gagal Mengirim";
        echo json_encode($response);
    }

} else {
    $response["error"] = true;
    $response["error_msg"] = "404";

    echo json_encode($response);
}
?>
