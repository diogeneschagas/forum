package br.com.alura.forum.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.alura.forum.config.validacao.ErroDeFormDto;

@RestControllerAdvice
public class ErroValidacaoHandler {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeFormDto> handler(MethodArgumentNotValidException exception) {
		List<ErroDeFormDto> dto = new ArrayList<>();

		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			/*
			 * LocaleContextoHoolder é um método que mapeia a localização do client e
			 * retorna uma mensagem de acordo com o idioma detectado
			 */
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroDeFormDto erro = new ErroDeFormDto(e.getField(), mensagem);
			dto.add(erro);
		});

		return dto;

	}
}
