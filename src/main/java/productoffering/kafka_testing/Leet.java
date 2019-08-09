package productoffering.kafka_testing;

public class Leet {

		    int reverse(int x) {
		        
		        String s = Integer.toString(x);
		        StringBuilder sb = new StringBuilder();
		        
		        if(s.charAt(0) != '-'){
		            
		           
		            int l = s.length();
		            for(int i =0; i<l; i++){
		                sb.append(s.charAt(l-i));
		            }
		        }
		        
		        return Integer.parseInt(sb.toString());
		    }
		};

