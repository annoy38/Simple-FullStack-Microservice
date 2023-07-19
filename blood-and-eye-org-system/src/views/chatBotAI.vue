<template>
  <div>
    <div class="card">
      <div class="card-border">
        <div class="container">
          <h1 style="margin: 20px;">Talk With AI</h1>
          <div class="Text-Area">
            <textarea id="text_area" ref="text_area" cols="30" rows="10"></textarea>
          </div>
          <div class="Query-Area">
            <input type="text" ref="query_area" id="query_area" placeholder="Enter your Query">
          </div>
          <div class="Btns">
            <button id="btn1" ref="myButton" @click="generateText">Generate Text</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import axios from 'axios';

export default {
  name: 'chatBotAI',
  data() {
    return {
      API_Key: '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',
      API_URL: 'https://api.openai.com/v1/chat/completions',
      requestCount: 0,
      lastRequestTime: 0,
      MAX_REQUESTS_PER_MINUTE: 60, // Define the maximum number of requests per minute
    };
  },
  methods: {
    generateText() {
      if (this.$refs.query_area.value === '') {
        alert('Invalid Input');
        this.$refs.query_area.value = '';
        return false;
      } else {
        this.$refs.myButton.disabled = true;
        this.$refs.myButton.style.cursor = 'wait';
        this.$refs.myButton.innerText = 'Generating...';
        const headers = {
          Authorization: `Bearer ${this.API_Key}`,
          'Content-Type': 'application/json',
        };
        const data = {
          model: 'gpt-3.5-turbo',
          messages: [{ role: 'user', content: this.$refs.query_area.value }],
        };

        this.makeRequest(data, headers);
      }
    },

    makeRequest(data, headers) {
      const currentTime = new Date().getTime();
      if (this.requestCount >= this.MAX_REQUESTS_PER_MINUTE && currentTime - this.lastRequestTime < 60000) {
        // Exceeded rate limit, display an error or take appropriate action
        console.error('Exceeded rate limit');
        this.$refs.myButton.disabled = false;
        this.$refs.myButton.style.cursor = 'pointer';
        return;
      }

      axios
        .post(this.API_URL, data, { headers })
        .then(response => {
          console.log(response.data);
          this.printLikeChatGPT(response.data.choices[0].message.content);
          this.$refs.myButton.disabled = true;
          this.$refs.myButton.innerText = 'Generate Text';
          this.$refs.query_area.value = '';

          // Update rate limiting variables
          this.requestCount++;
          this.lastRequestTime = currentTime;
        })
        .catch(error => {
          console.error(error);
          this.$refs.myButton.disabled = false;
          this.$refs.myButton.style.cursor = 'pointer';
        });
    },

    printLikeChatGPT(data) {
      this.$refs.myButton.disabled = false;
      this.$refs.myButton.style.cursor = 'pointer';
      const substring = data;
      let i = 0;
      const setInter = setInterval(() => {
        this.$refs.text_area.value += substring.slice(i, i + 5);
        i += 5;
        if (this.$refs.text_area.value == data) {
          clearInterval(setInter);
        }
      }, 200);
    },
  },
};

</script>

<style scoped>
.card {
  display: flex;
   /* background-color: #504fb5;  */
  height: 100%;
  justify-content: center;
}

.card-border {
  border: outset;
  color: black;
  background-color: rgb(255, 255, 255);
   box-shadow: rgba(132, 234, 229, 0.2) 0 80px 15px 15px;
  /* background-image: linear-gradient(144deg,#AF40FF, #5B42F3 50%,#00DDEB);  */
  border-radius: 20px;
  
}

.container {
  width: auto;
  height: 100%;
}
.Text-Area {
  display: flex;
  height: 28rem;
  justify-content: center;
}

#text_area {
  resize: none;
  height: 70%;
  color: rgba(69, 115, 176, 0.855);
  border-radius: 10px;
  width: 90%;
}

.Query-Area {
  display: flex;
  justify-content: center;
}

#query_area {
  display: flex;
  color: rgb(44, 98, 89);
  position: relative;
  margin: 5px;
  bottom: 130px;
  width: 85%;
  font-weight: bolder;
  height: 30px;
  padding: 10px;
  border-radius: 10px;
}

.Btns {
  display: flex;
  justify-content: center;
  position: relative;
  bottom: 125px;
  margin: 20px;
  width: 100%;
}

#btn1 {
  display: flex;
  width: 80%;
  background-color: black;
  color: white;
  height: 50px;
  font-weight: bold;
  border-radius: 12px;
  justify-content: center;
  align-items: center;
  margin-right: 30px;
}
#btn1:hover {
  display: flex;
  width: 80%;
  cursor:pointer;
  background-color: white;
  transition: 1s;
  color: black;
  border-radius: 12px;
  justify-content: center;
  align-items: center;
  margin-right: 30px;
}
</style>
