package com.demo.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

@Service
public class EmpService {

	@Autowired
	private EmpRepository empRepository;

	public Emp findById(Integer id) {
		Optional<Emp> empOp = empRepository.findById(id);
		if (empOp.isPresent()) {
			return empOp.get();
		} else {
			throw new RuntimeException("Emp Not found with id " + id);
		}
	}

	public List<Emp> findAllEmps() {
		return empRepository.findAll();
	}

	public Emp save(Emp e) {
		if (empRepository.existsById(e.getEmpId())) {
			throw new RuntimeException("Emp Exists with id " + e.getEmpId());
		} else {
			return empRepository.save(e);
		}
	}

	public Emp updateEmp(Emp e) {
		if (empRepository.existsById(e.getEmpId())) {
			return empRepository.save(e);

		} else {
			throw new RuntimeException("Emp Exists with id " + e.getEmpId());
		}
	}

	public void deleteEmp(Integer id) {
		if (empRepository.existsById(id)) {
			empRepository.deleteById(id);
			
		} else {
			throw new RuntimeException("Emp Not Found with id " + id);
		}
	}
}
