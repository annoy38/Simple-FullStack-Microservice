<template>
  <div class="container">
    <h1>Eye Request List</h1>
    <div class="container">
      <table class="table table-hover">
        <thead>
          <tr>
            <th scope="col">Patient Name</th>
            <th scope="col">Patient Number</th>
            <th scope="col">Hospital Name</th>
            <th scope="col">Patient Age</th>
            <th scope="col">Patient Gender</th>
            <th scope="col">Patient Blood Group</th>
          </tr>
        </thead>
        <tbody>
          <tr
            class="table-success"
            v-for="eyeReqList in eyeNotificationList"
            :key="eyeReqList.EyeNotificationClass.requestId"
          >
            <th scope="row">{{ eyeReqList.EyeNotificationClass.patientName }}</th>
            <td>{{ eyeReqList.EyeNotificationClass.patientNumber }}</td>
            <td>{{ eyeReqList.EyeNotificationClass.patientAddress }}</td>
            <td>{{ eyeReqList.EyeNotificationClass.patientGender }}</td>
            <td>{{ eyeReqList.EyeNotificationClass.patientAge }}</td>
            <td>{{ eyeReqList.EyeNotificationClass.patientBloodType }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import backendEyeRestApi from "@/service/backendEyeRestApi";
export default {
  name: "eyeRequestList",
  data() {
    return {
      eyeNotificationList: [],
    };
  },
  created() {
    this.fetchEyeReqList();
  },
  methods: {
    async fetchEyeReqList() {
      try {
        const response = await backendEyeRestApi.eyeReqList();
        // console.log(response.data);
        this.eyeNotificationList = response.data.map((eyeReqList) => ({
          EyeNotificationClass: {
            requestId: eyeReqList.requestId || "",
            patientName: eyeReqList.patientName || "",
            patientNumber: eyeReqList.patientNumber || "",
            patientAddress: eyeReqList.patientAddress || "",
            patientGender: eyeReqList.patientGender || "",
            patientAge: eyeReqList.patientAge || "",
            patientBloodType: eyeReqList.patientBloodType || "",
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
