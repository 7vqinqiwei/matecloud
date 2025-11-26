routes:
  # #{projectName}-uaa
  - id: #{projectName}-uaa
    predicates:
      - name: Path
        args:
          _genkey_0: /#{projectName}-uaa/**
    filters: []
    uri: lb://#{projectName}-uaa
    order: 0
  # #{projectName}-system
  - id: #{projectName}-system
    predicates:
      - name: Path
        args:
          _genkey_0: /#{projectName}-system/**
    filters:
      - name: RequestRateLimiter
        args:
          # 限流策略
          key-resolver: '#{@remoteAddrKeyResolver}'
          # 令牌桶每秒填充率
          redis-rate-limiter.burstCapacity: 20
          # 令牌桶容量
          redis-rate-limiter.replenishRate: 20
    uri: lb://#{projectName}-system
    order: 0
  # #{projectName}-component
  - id: #{projectName}-component
    predicates:
      - name: Path
        args:
          _genkey_0: /#{projectName}-component/**
    filters: []
    uri: lb://#{projectName}-component
    order: 0
  # #{projectName}-code
  - id: #{projectName}-code
    predicates:
      - name: Path
        args:
          _genkey_0: /#{projectName}-code/**
    filters: []
    uri: lb://#{projectName}-code
    order: 0
