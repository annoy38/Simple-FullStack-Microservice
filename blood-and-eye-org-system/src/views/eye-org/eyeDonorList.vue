<template>
      <div class="container">
    <h1>Eye Donor List</h1>
    <div class="container">
      <table class="table table-hover">
        <thead>
          <tr>
            <th scope="col">Donor Name</th>
            <th scope="col">Donor Email</th>
            <th scope="col">Donor Age</th>
            <th scope="col">Donor Gender</th>
            <th scope="col">Donor Address</th>
            <th scope="col">Donor Blood Group</th>
          </tr>
        </thead>
        <tbody>
          <tr
            class="table-success"
            v-for="donor in DonorsList"
            :key="donor.EyeDonarClass.donorId"
          >
            <th scope="row">{{ donor.EyeDonarClass.donorName }}</th>
            <td>{{ donor.EyeDonarClass.donorEmail }}</td>
            <td>{{ donor.EyeDonarClass.donorAge }}</td>
            <td>{{ donor.EyeDonarClass.donorGender }}</td>
            <td>{{ donor.EyeDonarClass.donorAddress }}</td>
            <td>{{ donor.EyeDonarClass.donorBloodType }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>

</template>

<script>
import backendEyeRestApi from '@/service/backendEyeRestApi'
export default{
    name: "eyeDonorList",
    data() {
    return {
      DonorsList: [],
    };
  },
  created() {
    this.fetchEyeDonorsInfo();
  },
  methods:{
    async fetchEyeDonorsInfo() {
      try {
        const response = await backendEyeRestApi.eyeDonorsList();
        this.DonorsList = response.data.map((donor) => ({
          EyeDonarClass: {
            donorId: donor.donorId || "",
            eyeOrganizationId: donor.eyeOrganizationId || "",
            donorName: donor.donorName || "",
            donorEmail: donor.donorEmail || "",
            donorAge: donor.donorAge || "",
            donorAddress: donor.donorAddress || "",
            donorBloodType: donor.donorBloodType || "",
            donorGender: donor.donorGender || "",
          },
        }));
      } catch (error) {
        console.log(error);
      }
    },
  }
}

</script>

<style>


</style>