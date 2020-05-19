<?php
/**
 * Created by PhpStorm.
 * User: lenovo
 * Date: 5/5/2019
 * Time: 10:01 PM
 */
include '../config.php';



if ($_POST) {

    $nik_user = $_POST['nik_user'];
    $nama_user = $_POST['nama_user'];
    $password = $_POST['password'];

    $sql = "INSERT INTO akun
(nik_user, nama_user, password, rule)
VALUE ('$nik_user', '$nama_user', '$password', 'user')";

    $query = mysqli_query($db, $sql);
    if ($query){
        $response["error"] = false;
        $response["error_msg"] = "Berhasil Registrasi";
        echo json_encode($response);
    } else{
        $response["error"] = false;
        $response["error_msg"] = "Gagal Mengirim";
        echo json_encode($response);
    }

}
else{
    $response["error"] = true;
    $response["error_msg"] = "404";

    echo json_encode($response);
}
?>