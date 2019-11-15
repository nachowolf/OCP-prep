package mess;

public class RE {


        public static class TextInput {
            StringBuilder sb = new StringBuilder();

            public void add(char c){
                sb.append(c);
            }

            public String getValue(){
                return sb.toString();
            }
        }

        public static class NumericInput extends TextInput{
            @Override
            public void add(char c){
                if(Character.isAlphabetic(c)){
                    sb.append(c);
                }
            }
        }

        public static void main(String[] args) {
            TextInput input = new NumericInput();
            input.add('1');
            input.add('a');
            input.add('0');
            System.out.println(input.getValue());
        }
    }

