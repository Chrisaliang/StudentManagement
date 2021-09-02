package com.nwpu.StudentManagement.dao;

//@Repository
//public class FakeStudentDao implements StudentDao {

//    private static final List<Student> database = new ArrayList<>();
//
//    @Override
//    public Optional<Student> selectStudentById(UUID id) {
//        for (Student student : database) {
//            if (student.getId().equals(id)) {
//                return Optional.of(student);
//            }
//        }
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Student> selectAllStudent() {
//        return database;
//    }
//
//    @Override
//    public int insertStudent(Student student) {
//        Student s = new Student(UUID.randomUUID(), student.getName());
//        database.add(s);
//        return 1;
//    }
//
//    @Override
//    public int updateStudent(Student student) {
//        Optional<Student> optionalStudent = selectStudentById(student.getId());
//        if (!optionalStudent.isPresent()) return -1;
//        for (int i = 0; i < database.size(); i++) {
//            if (database.get(i).getId().equals(student.getId())) {
//                database.set(i, student);
//                break;
//            }
//        }
//        return 1;
//    }
//
//    @Override
//    public int deleteStudentById(UUID id) {
//        Optional<Student> optionalStudent = selectStudentById(id);
//        if (!optionalStudent.isPresent()) return -1;
//        database.remove(optionalStudent.get());
//        return 1;
//    }

//}
