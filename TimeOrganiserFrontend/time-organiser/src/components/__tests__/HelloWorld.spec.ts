import { describe, it, expect } from 'vitest'

import { mount } from '@vue/test-utils'
import LogoComponent from '../LogoComponent.vue'

describe('LogoComponent', () => {
  it('renders the app logo', () => {
    const wrapper = mount(LogoComponent)
    expect(wrapper.find('svg').exists()).toBe(true)
  })
})
