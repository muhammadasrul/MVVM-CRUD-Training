<?php
/**
 * Created by PhpStorm.
 * User: lenovo
 * Date: 5/5/2019
 * Time: 10:01 PM
 */
include '../config.php';

if ($_POST) {

    $kode_training = $_POST['kode_training'];
    $nama_training = $_POST['nama_training'];
    $type_training = $_POST['type_training'];
    $jumlah_training = $_POST['jumlah_training'];
    $harga_training = $_POST['harga_training'];
    $tanggal_training = $_POST['tanggal_training'];
    $gambar_training = $_POST['gambar_training'];
    $status_training = $_POST['status_training'];


    $sql = "INSERT INTO training
(kode_training, nama_training, type_training, jumlah_training, harga_training, tanggal_training, gambar_training, status_training)
VALUE ('$kode_training', '$nama_training', '$type_training', '$jumlah_training', '$harga_training', '$tanggal_training', '$gambar_training', 'pending')";

    $query = mysqli_query($db, $sql);
    if ($query){
        $response["error"] = false;
        $response["error_msg"] = "Berhasil";
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