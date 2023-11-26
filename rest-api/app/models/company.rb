class Company < ApplicationRecord
    has_many :notes, dependent: :destroy
    validates :name, presence: true, uniqueness: true
end
