<?php
/**
 * Created by PhpStorm.
 * User: lenovo
 * Date: 5/5/2019
 * Time: 10:01 PM
 */
include '../config.php';

if ($_POST) {
    $id_training = $_POST['id_training'];
    $sql = mysqli_query($db, "UPDATE training SET status_training='aktif' where id_training='$id_training'");
    if ($sql){
        $response["error"] = false;
        $response["error_msg"] = "Berhasil";
        $response["regID"] = $id_training;
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

