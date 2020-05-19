<?php
/**
 * Created by PhpStorm.
 * User: lenovo
 * Date: 7/7/2019
 * Time: 8:28 PM
 */

include "../config.php";

if ($_GET){

    $status = $_GET['status_training'];

    $sql = mysqli_query($db, "Select * from training");
//    $sql = mysqli_query($db, "Select * from training where status_training = 'aktif'");

    while($data = mysqli_fetch_assoc($sql)){
        $arrayJson[] = $data;
    }
    $response = $arrayJson;
    echo json_encode($response);

} else {
    $response["error"] = true;
    $response["error_msg"] = "404";

    echo json_encode($response);
}
?>
