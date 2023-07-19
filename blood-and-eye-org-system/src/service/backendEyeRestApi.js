import axios from "@/axios";

class eyeRestApi {
  async registrationEyeOrg(accountClass) {
    try {
      return await axios.post(
        "auth/organization/eye-registration",
        accountClass
      );
    } catch (error) {
      console.log(error);
    }
  }

  async loginEyeOrganization(LoginRequestClass) {
    try {
      return await axios.post("auth/organization/token", LoginRequestClass);
    } catch (error) {
      console.log(error);
    }
  }

  async allEyeOrg() {
    try {
      return await axios.get("user/bloodusers/all-eye-organization");
    } catch (error) {
      console.log(error);
    }
  }

  async searchEyeOrgByDivision(searchValue) {
    try {
      return await axios.get(
        "user/bloodusers/all-eye-organization-in-division",
        {
          params: {
            eyeOrganizationDivision: searchValue,
          },
        }
      );
    } catch (error) {
      console.log(error);
    }
  }

  async searchEyeOrgByDistric(searchValue) {
    try {
      return await axios.get(
        "user/bloodusers/all-eye-organization-in-distric",
        {
          params: {
            eyeOrganizationDistric: searchValue,
          },
        }
      );
    } catch (error) {
      console.log(error);
    }
  }

  async searchEyeOrgByUpazila(searchValue) {
    try {
      return await axios.get(
        "user/bloodusers/all-eye-organization-in-upazila",
        {
          params: {
            eyeOrganizationUpazila: searchValue,
          },
        }
      );
    } catch (error) {
      console.log(error);
    }
  }

  async sendEyeRequest(EyeRequestClass) {
    try {
      return await axios.post(
        "user/bloodusers/sendeyerequest",
        EyeRequestClass
      );
    } catch (error) {
      console.log(error);
    }
  }

  async eyeOrgProfilePage() {
    try {
      return await axios.get("organization/eyeorganization/profile");
    } catch (error) {
      console.log(error);
    }
  }

  async deleteEyeAccount() {
    try {
      return await axios.delete("organization/eyeorganization/delete-account");
    } catch (error) {
      console.log(error);
    }
  }

  async addEyeDonors(EyeDonarClass) {
    try {
      return await axios.post(
        "organization/eyeorganization/save-donor-info",
        EyeDonarClass
      );
    } catch (error) {
      console.log(error);
    }
  }

  async eyeDonorsList() {
    try {
      return await axios.get("organization/eyeorganization/get-all-eye-donors");
    } catch (error) {
      console.log(error);
    }
  }

  async eyeDeliveryRequest(DeliveryRequestClass) {
    try {
      return await axios.post(
        "organization/eyeorganization/delivery-request",
        DeliveryRequestClass
      );
    } catch (error) {
      console.log(error);
    }
  }

  async eyeDeliveryRequestList() {
    try {
      return await axios.get(
        "organization/eyeorganization/all-delivery-request"
      );
    } catch (error) {
      console.log(error);
    }
  }

  async eyeReqList() {
    try {
      return await axios.get("organization/eyeorganization/eye-requests");
    } catch (error) {
      console.log(error);
    }
  }
}
export default new eyeRestApi();
