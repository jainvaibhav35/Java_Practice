package ntgu_jira;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class csvToCopyScript {

    public static void main(String[] args) {
        String fileNameDefined;
        String projectTitle;
        String scriptAction = "~/atlassian-cli-7.8.0/confluence.sh --action ";
        String action = ""; //should be copypage or addattachment
        String scriptTitle = " --space \"HPQC\" --title \"";
        String title = "";
        String scriptName = "\" --name \"";
        String attachmentName = "";
        String scriptFile = "\" --file \"";
        String scriptComment = "\" --comment \"";
        String scriptEnd = "\"";
        String scriptNewTitle = "\" --newTitle \"";
        String scriptParent = "\" --parent \"";
        String parent = "HPQC Home";
        PrintWriter pageCopyWriter;
        PrintWriter addAttachmentWriter;

        args = doStaticDeclaration(args);


        if ((args.length < 6) ||
            !(args[0].equals("--project")) ||
            !(args[2].equals("--csvinfofile")) ||
            !(args[4].equals("--csvverfile"))) {
            System.out.print("usage: csvToCopyScript --project <project name> --csvinfofile <CSV Info File name> --csvverfile <CSV Ver File Name>\n");
            System.exit(-1);
        }
        fileNameDefined = args[5];
        File verfile = new File(fileNameDefined);
        Map<String, String> verMap = new HashMap<String, String>();
        Scanner verStream;
        try{
            verStream = new Scanner(verfile);

            while(verStream.hasNext()){
                String line= verStream.next();
                String[] values = line.split(",");
                if (values.length == 2) {
                    verMap.put(values[0],values[1] );
                }
            }
            verStream.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        fileNameDefined = args[3];
        projectTitle = args[1];
        File infofile = new File(fileNameDefined);

        try{
            pageCopyWriter = new PrintWriter(projectTitle +"_PageCopy.sh", "UTF-8");
            String addTitlePage = scriptAction + "copypage" + scriptTitle + "Parent Page Template" + scriptNewTitle + projectTitle + scriptParent + parent + scriptEnd;
            pageCopyWriter.println(addTitlePage);
            addAttachmentWriter = new PrintWriter(projectTitle +"_AddAttachment.sh", "UTF-8");
            Scanner inputStream = new Scanner(infofile);
            String line = inputStream.nextLine();
            String crKey1 = "";
            String curPageTitle = "";
            String addAttachment;
            int index = 1;
            String pagelabel = "";
            while(inputStream.hasNextLine()){
                line = inputStream.nextLine();
                String[] fields = line.split(",");
                //Get the Attachment Name
                attachmentName = fields[2];
                attachmentName = attachmentName.replace("\"", "");
                String temp = fields[0]+'_'+crKey1+'_';
                temp = temp.replace("\"", "");
                attachmentName = attachmentName.replace(temp, "");
                if (!crKey1.equals(fields[1])) {
                    crKey1 = fields[1];
                    String temp1 = crKey1;
                    temp1 = temp1.replace("\"", "");
                    pagelabel = verMap.get(temp1);
                    curPageTitle = projectTitle+'_'+pagelabel;
                    curPageTitle = curPageTitle.replace("\"", "");
                    //Got a new Release Add a new Page after determining the version
                    addTitlePage = scriptAction +  "copypage" + scriptTitle + "Child Page Template" + scriptNewTitle + curPageTitle + scriptParent + projectTitle + scriptEnd;
                    pageCopyWriter.println(addTitlePage);
                    pagelabel = pagelabel.replace(".", "_");
                    pagelabel = pagelabel.replace("(", "_");
                    index = 1;
                }
                String filePath =  fields[4].replace('\\', '/');
                //System.out.print(filePath);
                //for (int i=0; i < fields.length; i++){
                //   System.out.print(fields[i] + "|");
                //}
                //System.out.println();
                String commentIndex = '('+ Integer.toString(index)+')';
                if (index == 1) {
                    addAttachment = scriptAction + "addAttachment" + scriptTitle + curPageTitle + scriptName + commentIndex + attachmentName + scriptFile + filePath + scriptComment + commentIndex + fields[3] + "\" --labels \"" + pagelabel + scriptEnd;
                } else {
                    addAttachment = scriptAction + "addAttachment" + scriptTitle + curPageTitle + scriptName + commentIndex + attachmentName + scriptFile + filePath + scriptComment + commentIndex + fields[3] + scriptEnd;
                }
                addAttachmentWriter.println(addAttachment);
                index++;
            }
            inputStream.close();
            pageCopyWriter.close();
            addAttachmentWriter.close(); 
        }catch (FileNotFoundException |UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    private static String[] doStaticDeclaration(String args[]) {

        args = new String[6];

        args[0] = "--project";
        args[1] = "Title of the Project";
        args[2] = "--csvinfofile";
        args[3] = "/home/linchpin/Downloads/May1_2018/C3700_RELEASE_FOLDERS_INFO_201805011148.csv";
        args[4] = "--csvverfile";
        args[5] = "/home/linchpin/Downloads/May1_2018/C3700_RELEASE_FOLDERS_VER_201805011150.csv";

        return args ;
    }

}
