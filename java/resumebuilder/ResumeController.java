package java.resumebuilder;

@Controller
public class ResumeController {

    @RequestMapping(value = "/createResume", method = RequestMethod.POST)
    public void createResume(@RequestParam("name") String name,
                             @RequestParam("email") String email,
                             @RequestParam("phone") String phone,
                             @RequestParam("address") String address,
                             @RequestParam("education") List<Education> education,
                             @RequestParam("workExperience") List<WorkExperience> workExperience,
                             @RequestParam("skills") List<String> skills,
                             HttpServletResponse response) throws IOException {
        ResumeBuilder resumeBuilder = new ResumeBuilder();
        resumeBuilder.setName(name);
        resumeBuilder.setEmail(email);
        resumeBuilder.setPhone(phone);
        resumeBuilder.setAddress(address);
        resumeBuilder.setEducation(education);
        resumeBuilder.setWorkExperience(workExperience);
        resumeBuilder.setSkills(skills);

        // create the resume
        File tempFile = File.createTempFile("resume", ".docx");
        FileOutputStream out = new FileOutputStream(tempFile);
        resumeBuilder.createResume(out);
        out.close();

        // prompt the user to download the file
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + tempFile.getName());
        response.setContentLength((int) tempFile.length());
        InputStream inputStream = new BufferedInputStream(new FileInputStream(tempFile));
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }
}

