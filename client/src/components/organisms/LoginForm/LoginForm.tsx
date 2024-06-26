import React, { useState } from 'react';
import styled from 'styled-components';
import axios from 'axios';
import Button from '@/atoms/Button';
import Input from '@/atoms/Input';
import { ILoginForm } from '@/apis/user/user';
import { postLogin } from '@/apis/user/post-login';
import { Link, useNavigate } from 'react-router-dom';
import { useRecoilState } from 'recoil';
import userSessionAtom from '@/recoil/atoms/userSession';
import { checkAuth } from '@/apis/user/check-auth';

const LoginForm = () => {
  const navigate = useNavigate();
  const [userSession, setUserSession] = useRecoilState(userSessionAtom);

  const [loginFormData, setLoginFormData] = useState<ILoginForm>({
    username: '',
    password: '',
  });

  const getLoginFormValue = (e: React.FormEvent<HTMLInputElement>, name: string) => {
    const inputValue = e.currentTarget.value;
    setLoginFormData((prev) => ({ ...prev, [name]: inputValue }));
  };

  const handleClickLoginButton = async () => {
    const data = await postLogin(loginFormData);
    if (data) {
      const { accessToken } = data;
      localStorage.setItem('accessToken', accessToken);
      axios.defaults.headers.common['Authorization'] = 'Bearer ' + accessToken;
      const d = await checkAuth();
      if (d && d.isLogin) {
        setUserSession({
          userId: d.userId as string,
          username: d.username as string,
        });
      }
      alert(`로그인 성공`);
      navigate('/');
    } else {
      alert(`로그인 실패`);
    }
  };

  return (
    <StyledLoginForm onSubmit={(e) => e.preventDefault()}>
      <div className="login-form__input-box">
        <Input
          label={'아이디'}
          name={'username'}
          handleInput={(e) => getLoginFormValue(e, 'username')}
        />
        <Input
          label={'패스워드'}
          name={'password'}
          handleInput={(e) => getLoginFormValue(e, 'password')}
        />
      </div>
      <ButtonWrapper>
        <Button content={'로그인'} onClick={handleClickLoginButton} />
      </ButtonWrapper>
      <LinkWrapper>
        <Link to="/signup">회원가입</Link>
      </LinkWrapper>
    </StyledLoginForm>
  );
};

const StyledLoginForm = styled.form`
  display: flex;
  flex-direction: column;
  padding: 10px;
  height: 100%;

  .login-form__input-box {
    margin-bottom: 20px;
    display: flex;
    flex-direction: column;
    gap: 12px;
  }
`;

const LinkWrapper = styled.div`
  padding: 16px 0;
  text-align: right;

  a {
    color: ${({ theme }) => theme.LIGHT_BLACK};
    text-decoration: underline;
  }
`;

const ButtonWrapper = styled.div`
  height: 36px;
  button {
    height: 100%;
  }
`;

export default LoginForm;
