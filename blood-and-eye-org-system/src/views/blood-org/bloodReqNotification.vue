<template>
      <div class="container">
    <h1>Blood Request List</h1>
    <div class="container">
      <table class="table table-hover">
        <thead>
          <tr>
            <th scope="col">Patient Name</th>
            <th scope="col">Patient Number</th>
            <th scope="col">Hospital Name</th>
            <th scope="col">Requested Blood Group</th>
          </tr>
        </thead>
        <tbody>
          <tr
            class="table-success"
            v-for="bloodList in notificationList"
            :key="bloodList.NotificationClass.requestId"
          >
            <th scope="row">{{ bloodList.NotificationClass.patientName }}</th>
            <td>{{ bloodList.NotificationClass.patientNumber }}</td>
            <td>{{ bloodList.NotificationClass.hospitalName }}</td>
            <td>{{ bloodList.NotificationClass.requestedBloodType }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import backendRestApi from "@/service/backendRestApi";
export default {
  name: "bloodReqNotification",
  data() {
    return {
      notificationList: [],
    };
  },
  created() {
    this.fetchBloodReqNotification();
  },
  methods: {
    async fetchBloodReqNotification() {
      try {
        const response = await backendRestApi.bloodReqList();
        // console.log(response.data);
        this.notificationList = response.data.map((bloodList) => ({
          NotificationClass: {
            requestId: bloodList.requestId || "",
            patientName: bloodList.patientName || "",
            patientNumber: bloodList.patientNumber || "",
            hospitalName: bloodList.hospitalName || "",
            requestedBloodType: bloodList.requestedBloodType || "",
          },
        }));
      } catch (error) {
        console.log(error);
      }
    },
  },
};
</script>

<style></style>
