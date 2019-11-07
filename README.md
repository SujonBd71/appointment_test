# appointment_test
This is a very basic dentist appointment web service implemented using Spring boot. This reposity also has a running jar file under the target directory. https://github.com/SujonBd71/appointment_test/blob/master/light-house-ws/target/light-house-ws-0.0.1-SNAPSHOT.jar

features and limitations.
1. Only in memory data structure. Database support was left out for simplicity
2. Alorithm was also kept simple. Dentist avalibility look up time is linear. Time complexity is O(N) where N is number of appointment intervals for a particular dentist.

3. Algorithm can be improved in logarithmic time O(logN) using interval tree seach algorithm. 
