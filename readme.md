
## Docker Client implemenation for conatiner read along with start and stop operations .
Task is to add the necessary features to the current project's API blueprint structure to enable
it to manage **Docker** containers, also referred to as workers, as fallows:

🔄 Integrated the 🐳 Docker Java library (https://github.com/docker-java/docker-java/blob/main/docs/getting_started.md) to enable connect and manage 👷‍♀️ workers.

➕ Added the required fields and database migration for the 👷‍♂️ Worker entity to keep **all** the information associated on available at the container level (like 🔌 ports, 👨‍💼 name, 🟢 status, etc..)

🆕 Added required entities and tables to track the 👷‍♂️ Worker statistics.

🆙 Updates on the 👷‍♂️ WorkerController for actions:
* 📄 List workers (paginated)
* ▶️ Start and ⏹️ Stop worker
* 🔍 Get worker information
* 📊 Get worker statistics
